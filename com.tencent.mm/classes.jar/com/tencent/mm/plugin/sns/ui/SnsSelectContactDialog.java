package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private List<String> hqR;
  private GridView yPJ;
  private a yPK;
  
  public SnsSelectContactDialog()
  {
    AppMethodBeat.i(99009);
    this.yPJ = null;
    this.yPK = null;
    this.hqR = new LinkedList();
    AppMethodBeat.o(99009);
  }
  
  private boolean avJ(String paramString)
  {
    AppMethodBeat.i(99012);
    String[] arrayOfString = w.hmW;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i]))
      {
        AppMethodBeat.o(99012);
        return false;
      }
      i += 1;
    }
    if (w.sQ(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if (w.wH(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if ((this.hqR != null) && (this.hqR.contains(paramString)))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    AppMethodBeat.o(99012);
    return true;
  }
  
  private String dQf()
  {
    AppMethodBeat.i(99013);
    Object localObject1 = ((k)g.ab(k.class)).awG();
    Object localObject2 = w.hmN;
    Object localObject3 = new LinkedList();
    String[] arrayOfString = w.hmW;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject3).add(arrayOfString[i]);
      i += 1;
    }
    ((List)localObject3).add("weixin");
    ((List)localObject3).add("officialaccounts");
    ((List)localObject3).add("helper_entry");
    ((List)localObject3).add("filehelper");
    localObject1 = ((bk)localObject1).c((String)localObject2, (List)localObject3, "*");
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(99013);
      return "";
    }
    localObject2 = new LinkedList();
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject3 = new ap();
      ((ap)localObject3).convertFrom((Cursor)localObject1);
      if (avJ(((az)localObject3).field_username))
      {
        ((List)localObject2).add(((az)localObject3).field_username);
        if (((List)localObject2).size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    localObject1 = bs.n((List)localObject2, ";");
    AppMethodBeat.o(99013);
    return localObject1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99014);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99014);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99014);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      paramIntent = bs.S(paramIntent.getStringExtra("Select_Contact").split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      if (this.hqR == null) {
        this.hqR = new LinkedList();
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        if (!this.hqR.contains(str)) {
          this.hqR.add(str);
        }
      }
      ac.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.hqR.size());
      if (this.yPK != null)
      {
        ac.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
        this.yPK.refresh();
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Select_Contact", bs.n(this.hqR, ","));
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99010);
    super.onCreate(paramBundle);
    setContentView(2131495534);
    paramBundle = getIntent().getStringExtra("Select_Contact");
    if ((paramBundle == null) || (paramBundle.equals(""))) {
      this.hqR.clear();
    }
    for (;;)
    {
      this.yPJ = ((GridView)findViewById(2131298755));
      this.yPK = new a(this, this.hqR);
      this.yPJ.setAdapter(this.yPK);
      this.yPJ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(99003);
          if (paramAnonymousInt == SnsSelectContactDialog.a(SnsSelectContactDialog.this).getCount() - 1) {
            SnsSelectContactDialog.b(SnsSelectContactDialog.this);
          }
          for (;;)
          {
            SnsSelectContactDialog.a(SnsSelectContactDialog.this).refresh();
            AppMethodBeat.o(99003);
            return;
            SnsSelectContactDialog.c(SnsSelectContactDialog.this).remove(paramAnonymousInt);
          }
        }
      });
      this.yPJ.setSelection(this.yPK.getCount() - 1);
      ((ImageButton)findViewById(2131298364)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99004);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Contact", bs.n(SnsSelectContactDialog.c(SnsSelectContactDialog.this), ","));
          SnsSelectContactDialog.this.setResult(-1, paramAnonymousView);
          SnsSelectContactDialog.this.finish();
          AppMethodBeat.o(99004);
        }
      });
      AppMethodBeat.o(99010);
      return;
      this.hqR = bs.S(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99011);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", bs.n(this.hqR, ","));
      setResult(-1, localIntent);
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(99011);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private Context context;
    private List<String> hqR;
    private int type;
    private int ywI;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(99005);
      this.ywI = 0;
      Object localObject;
      this.hqR = localObject;
      this.context = paramInt;
      this.type = 0;
      refresh();
      AppMethodBeat.o(99005);
    }
    
    public final int getCount()
    {
      return this.ywI;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(99007);
      Object localObject = this.hqR.get(paramInt);
      AppMethodBeat.o(99007);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(99008);
      if (paramView == null)
      {
        paramViewGroup = new SnsSelectContactDialog.b();
        if (this.type == 0)
        {
          paramView = View.inflate(this.context, 2131495617, null);
          paramViewGroup.image = ((ImageView)paramView.findViewById(2131300914));
          paramViewGroup.yPM = ((ImageView)paramView.findViewById(2131301148));
          paramView.setTag(paramViewGroup);
          label66:
          paramView.setVisibility(0);
          if (paramInt != this.ywI - 1) {
            break label170;
          }
          paramViewGroup.image.setBackgroundDrawable(null);
          paramViewGroup.image.setImageResource(2131234098);
          paramViewGroup.yPM.setVisibility(8);
          if (this.hqR.size() >= ag.GDt) {
            paramView.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        AppMethodBeat.o(99008);
        return paramView;
        paramView = View.inflate(this.context, 2131495526, null);
        break;
        paramViewGroup = (SnsSelectContactDialog.b)paramView.getTag();
        break label66;
        label170:
        paramViewGroup.image.setBackgroundDrawable(null);
        paramViewGroup.yPM.setVisibility(0);
        Object localObject;
        if (this.type == 0)
        {
          localObject = (String)this.hqR.get(paramInt);
          a.b.c(paramViewGroup.image, (String)localObject);
        }
        else
        {
          localObject = f.e((String)this.hqR.get(paramInt), af.dIc(), af.dIc(), true);
          paramViewGroup.image.setImageBitmap((Bitmap)localObject);
        }
      }
    }
    
    public final void refresh()
    {
      AppMethodBeat.i(99006);
      if (this.hqR == null) {}
      for (this.ywI = 0;; this.ywI = this.hqR.size())
      {
        this.ywI += 1;
        notifyDataSetChanged();
        AppMethodBeat.o(99006);
        return;
      }
    }
  }
  
  static final class b
  {
    ImageView image;
    ImageView yPM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */