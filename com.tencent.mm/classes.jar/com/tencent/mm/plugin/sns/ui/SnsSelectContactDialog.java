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
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private List<String> gQr;
  private GridView xCV;
  private a xCW;
  
  public SnsSelectContactDialog()
  {
    AppMethodBeat.i(99009);
    this.xCV = null;
    this.xCW = null;
    this.gQr = new LinkedList();
    AppMethodBeat.o(99009);
  }
  
  private boolean aqA(String paramString)
  {
    AppMethodBeat.i(99012);
    String[] arrayOfString = w.gMw;
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
    if (w.pF(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if (w.sE(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if ((this.gQr != null) && (this.gQr.contains(paramString)))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    AppMethodBeat.o(99012);
    return true;
  }
  
  private String dBI()
  {
    AppMethodBeat.i(99013);
    Object localObject1 = ((k)g.ab(k.class)).apR();
    Object localObject2 = w.gMn;
    Object localObject3 = new LinkedList();
    String[] arrayOfString = w.gMw;
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
    localObject1 = ((bh)localObject1).c((String)localObject2, (List)localObject3, "*");
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
      localObject3 = new am();
      ((am)localObject3).convertFrom((Cursor)localObject1);
      if (aqA(((ay)localObject3).field_username))
      {
        ((List)localObject2).add(((ay)localObject3).field_username);
        if (((List)localObject2).size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    localObject1 = bt.n((List)localObject2, ";");
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
      paramIntent = bt.S(paramIntent.getStringExtra("Select_Contact").split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      if (this.gQr == null) {
        this.gQr = new LinkedList();
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        if (!this.gQr.contains(str)) {
          this.gQr.add(str);
        }
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.gQr.size());
      if (this.xCW != null)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
        this.xCW.refresh();
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Select_Contact", bt.n(this.gQr, ","));
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
      this.gQr.clear();
    }
    for (;;)
    {
      this.xCV = ((GridView)findViewById(2131298755));
      this.xCW = new a(this, this.gQr);
      this.xCV.setAdapter(this.xCW);
      this.xCV.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
      this.xCV.setSelection(this.xCW.getCount() - 1);
      ((ImageButton)findViewById(2131298364)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99004);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Contact", bt.n(SnsSelectContactDialog.c(SnsSelectContactDialog.this), ","));
          SnsSelectContactDialog.this.setResult(-1, paramAnonymousView);
          SnsSelectContactDialog.this.finish();
          AppMethodBeat.o(99004);
        }
      });
      AppMethodBeat.o(99010);
      return;
      this.gQr = bt.S(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99011);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", bt.n(this.gQr, ","));
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
    private List<String> gQr;
    private int type;
    private int xjP;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(99005);
      this.xjP = 0;
      Object localObject;
      this.gQr = localObject;
      this.context = paramInt;
      this.type = 0;
      refresh();
      AppMethodBeat.o(99005);
    }
    
    public final int getCount()
    {
      return this.xjP;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(99007);
      Object localObject = this.gQr.get(paramInt);
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
          paramViewGroup.xCY = ((ImageView)paramView.findViewById(2131301148));
          paramView.setTag(paramViewGroup);
          label66:
          paramView.setVisibility(0);
          if (paramInt != this.xjP - 1) {
            break label170;
          }
          paramViewGroup.image.setBackgroundDrawable(null);
          paramViewGroup.image.setImageResource(2131234098);
          paramViewGroup.xCY.setVisibility(8);
          if (this.gQr.size() >= com.tencent.mm.storage.ad.FfG) {
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
        paramViewGroup.xCY.setVisibility(0);
        Object localObject;
        if (this.type == 0)
        {
          localObject = (String)this.gQr.get(paramInt);
          a.b.c(paramViewGroup.image, (String)localObject);
        }
        else
        {
          localObject = f.e((String)this.gQr.get(paramInt), af.dtE(), af.dtE(), true);
          paramViewGroup.image.setImageBitmap((Bitmap)localObject);
        }
      }
    }
    
    public final void refresh()
    {
      AppMethodBeat.i(99006);
      if (this.gQr == null) {}
      for (this.xjP = 0;; this.xjP = this.gQr.size())
      {
        this.xjP += 1;
        notifyDataSetChanged();
        AppMethodBeat.o(99006);
        return;
      }
    }
  }
  
  static final class b
  {
    ImageView image;
    ImageView xCY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */