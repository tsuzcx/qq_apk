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
import com.tencent.mm.g.c.bb;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private GridView EHJ;
  private a EHK;
  private List<String> iHf;
  
  public SnsSelectContactDialog()
  {
    AppMethodBeat.i(99009);
    this.EHJ = null;
    this.EHK = null;
    this.iHf = new LinkedList();
    AppMethodBeat.o(99009);
  }
  
  private boolean aRc(String paramString)
  {
    AppMethodBeat.i(99012);
    String[] arrayOfString = ab.iCO;
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
    if (ab.Eq(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if (ab.IT(paramString))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    if ((this.iHf != null) && (this.iHf.contains(paramString)))
    {
      AppMethodBeat.o(99012);
      return false;
    }
    AppMethodBeat.o(99012);
    return true;
  }
  
  private String fiC()
  {
    AppMethodBeat.i(99013);
    Object localObject1 = ((l)g.af(l.class)).aST();
    Object localObject2 = ab.iCF;
    Object localObject3 = new LinkedList();
    String[] arrayOfString = ab.iCO;
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
    localObject1 = ((bw)localObject1).c((String)localObject2, (List)localObject3, "*");
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
      localObject3 = new az();
      ((az)localObject3).convertFrom((Cursor)localObject1);
      if (aRc(((bb)localObject3).field_username))
      {
        ((List)localObject2).add(((bb)localObject3).field_username);
        if (((List)localObject2).size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    localObject1 = Util.listToString((List)localObject2, ";");
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
      paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
      if (paramIntent == null)
      {
        AppMethodBeat.o(99014);
        return;
      }
      if (this.iHf == null) {
        this.iHf = new LinkedList();
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        String str = (String)paramIntent.next();
        if (!this.iHf.contains(str)) {
          this.iHf.add(str);
        }
      }
      Log.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.iHf.size());
      if (this.EHK != null)
      {
        Log.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
        this.EHK.refresh();
      }
      paramIntent = new Intent();
      paramIntent.putExtra("Select_Contact", Util.listToString(this.iHf, ","));
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99010);
    super.onCreate(paramBundle);
    setContentView(2131496422);
    paramBundle = getIntent().getStringExtra("Select_Contact");
    if ((paramBundle == null) || (paramBundle.equals(""))) {
      this.iHf.clear();
    }
    for (;;)
    {
      this.EHJ = ((GridView)findViewById(2131299198));
      this.EHK = new a(this, this.iHf);
      this.EHJ.setAdapter(this.EHK);
      this.EHJ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(99003);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (paramAnonymousInt == SnsSelectContactDialog.a(SnsSelectContactDialog.this).getCount() - 1) {
            SnsSelectContactDialog.b(SnsSelectContactDialog.this);
          }
          for (;;)
          {
            SnsSelectContactDialog.a(SnsSelectContactDialog.this).refresh();
            a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(99003);
            return;
            SnsSelectContactDialog.c(SnsSelectContactDialog.this).remove(paramAnonymousInt);
          }
        }
      });
      this.EHJ.setSelection(this.EHK.getCount() - 1);
      ((ImageButton)findViewById(2131298770)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99004);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Select_Contact", Util.listToString(SnsSelectContactDialog.c(SnsSelectContactDialog.this), ","));
          SnsSelectContactDialog.this.setResult(-1, paramAnonymousView);
          SnsSelectContactDialog.this.finish();
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99004);
        }
      });
      AppMethodBeat.o(99010);
      return;
      this.iHf = Util.stringsToList(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(99011);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", Util.listToString(this.iHf, ","));
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
    private int Eny;
    private Context context;
    private List<String> iHf;
    private int type;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(99005);
      this.Eny = 0;
      Object localObject;
      this.iHf = localObject;
      this.context = paramInt;
      this.type = 0;
      refresh();
      AppMethodBeat.o(99005);
    }
    
    public final int getCount()
    {
      return this.Eny;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(99007);
      Object localObject = this.iHf.get(paramInt);
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
          paramView = View.inflate(this.context, 2131496516, null);
          paramViewGroup.image = ((ImageView)paramView.findViewById(2131302526));
          paramViewGroup.EHM = ((ImageView)paramView.findViewById(2131302803));
          paramView.setTag(paramViewGroup);
          label66:
          paramView.setVisibility(0);
          if (paramInt != this.Eny - 1) {
            break label170;
          }
          paramViewGroup.image.setBackgroundDrawable(null);
          paramViewGroup.image.setImageResource(2131234957);
          paramViewGroup.EHM.setVisibility(8);
          if (this.iHf.size() >= aq.NSd) {
            paramView.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        AppMethodBeat.o(99008);
        return paramView;
        paramView = View.inflate(this.context, 2131496414, null);
        break;
        paramViewGroup = (SnsSelectContactDialog.b)paramView.getTag();
        break label66;
        label170:
        paramViewGroup.image.setBackgroundDrawable(null);
        paramViewGroup.EHM.setVisibility(0);
        Object localObject;
        if (this.type == 0)
        {
          localObject = (String)this.iHf.get(paramInt);
          a.b.c(paramViewGroup.image, (String)localObject);
        }
        else
        {
          localObject = BitmapUtil.extractThumbNail((String)this.iHf.get(paramInt), aj.fbb(), aj.fbb(), true);
          paramViewGroup.image.setImageBitmap((Bitmap)localObject);
        }
      }
    }
    
    public final void refresh()
    {
      AppMethodBeat.i(99006);
      if (this.iHf == null) {}
      for (this.Eny = 0;; this.Eny = this.iHf.size())
      {
        this.Eny += 1;
        notifyDataSetChanged();
        AppMethodBeat.o(99006);
        return;
      }
    }
  }
  
  static final class b
  {
    ImageView EHM;
    ImageView image;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */