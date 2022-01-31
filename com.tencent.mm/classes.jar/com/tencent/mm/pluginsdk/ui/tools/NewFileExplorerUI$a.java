package com.tencent.mm.pluginsdk.ui.tools;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NewFileExplorerUI$a
  extends BaseAdapter
{
  private File weq;
  File[] wer;
  private File wfo;
  private boolean wfp;
  private ArrayList<File> wfq;
  
  public NewFileExplorerUI$a(NewFileExplorerUI paramNewFileExplorerUI)
  {
    AppMethodBeat.i(28186);
    this.wer = new File[0];
    this.wfp = false;
    this.wfq = new ArrayList();
    AppMethodBeat.o(28186);
  }
  
  private void a(File[] paramArrayOfFile)
  {
    AppMethodBeat.i(28193);
    if ((paramArrayOfFile == null) || (paramArrayOfFile.length == 0))
    {
      AppMethodBeat.o(28193);
      return;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    int j = paramArrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramArrayOfFile[i];
      a locala = new a((byte)0);
      locala.file = localFile;
      locala.time = localFile.lastModified();
      if (localFile.isDirectory())
      {
        locala.wfs = g.wq(localFile.getName()).toUpperCase();
        ((List)localObject2).add(locala);
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject1).add(locala);
      }
    }
    Collections.sort((List)localObject2, new NewFileExplorerUI.a.2(this));
    Collections.sort((List)localObject1, new NewFileExplorerUI.a.3(this));
    localObject2 = ((List)localObject2).iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      paramArrayOfFile[i] = ((a)((Iterator)localObject2).next()).file;
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramArrayOfFile[i] = ((a)((Iterator)localObject1).next()).file;
      i += 1;
    }
    AppMethodBeat.o(28193);
  }
  
  private static boolean aG(String paramString)
  {
    AppMethodBeat.i(28197);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")))
    {
      AppMethodBeat.o(28197);
      return true;
    }
    AppMethodBeat.o(28197);
    return false;
  }
  
  static boolean aH(String paramString)
  {
    AppMethodBeat.i(28198);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
    {
      AppMethodBeat.o(28198);
      return true;
    }
    AppMethodBeat.o(28198);
    return false;
  }
  
  private static int amF(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = paramString.toLowerCase();
    if (amK(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230830;
    }
    if (amG(paramString))
    {
      AppMethodBeat.o(28195);
      return 2130837708;
    }
    if (amJ(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230818;
    }
    if (amO(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230821;
    }
    if (amL(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230813;
    }
    if (amM(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230816;
    }
    if (amN(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230802;
    }
    if (aG(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230809;
    }
    if (aH(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230826;
    }
    if (amQ(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230829;
    }
    if (amP(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230806;
    }
    if (isNumber(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230811;
    }
    if (amR(paramString))
    {
      AppMethodBeat.o(28195);
      return 2131230812;
    }
    AppMethodBeat.o(28195);
    return 2131230822;
  }
  
  private static boolean amG(String paramString)
  {
    AppMethodBeat.i(28196);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((Build.VERSION.SDK_INT >= 28) && (paramString.endsWith(".heic")))
    {
      AppMethodBeat.o(28196);
      return true;
    }
    if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
    {
      AppMethodBeat.o(28196);
      return true;
    }
    AppMethodBeat.o(28196);
    return false;
  }
  
  private static boolean amJ(String paramString)
  {
    AppMethodBeat.i(28199);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".rar")) || (paramString.endsWith(".zip")) || (paramString.endsWith(".7z")) || (paramString.endsWith("tar")) || (paramString.endsWith(".iso")))
    {
      AppMethodBeat.o(28199);
      return true;
    }
    AppMethodBeat.o(28199);
    return false;
  }
  
  private static boolean amK(String paramString)
  {
    AppMethodBeat.i(28200);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
    {
      AppMethodBeat.o(28200);
      return true;
    }
    AppMethodBeat.o(28200);
    return false;
  }
  
  private static boolean amL(String paramString)
  {
    AppMethodBeat.i(28201);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
    AppMethodBeat.o(28201);
    return bool;
  }
  
  private static boolean amM(String paramString)
  {
    AppMethodBeat.i(28202);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
    {
      AppMethodBeat.o(28202);
      return true;
    }
    AppMethodBeat.o(28202);
    return false;
  }
  
  private static boolean amN(String paramString)
  {
    AppMethodBeat.i(28203);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
    {
      AppMethodBeat.o(28203);
      return true;
    }
    AppMethodBeat.o(28203);
    return false;
  }
  
  private static boolean amO(String paramString)
  {
    AppMethodBeat.i(28204);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".txt")) || (paramString.endsWith(".rtf")))
    {
      AppMethodBeat.o(28204);
      return true;
    }
    AppMethodBeat.o(28204);
    return false;
  }
  
  private static boolean amP(String paramString)
  {
    AppMethodBeat.i(28205);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().endsWith(".key");
    AppMethodBeat.o(28205);
    return bool;
  }
  
  private static boolean amQ(String paramString)
  {
    AppMethodBeat.i(28206);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().endsWith(".html");
    AppMethodBeat.o(28206);
    return bool;
  }
  
  private static boolean amR(String paramString)
  {
    AppMethodBeat.i(28208);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().endsWith(".pages");
    AppMethodBeat.o(28208);
    return bool;
  }
  
  private static boolean isNumber(String paramString)
  {
    AppMethodBeat.i(28207);
    boolean bool = bo.nullAsNil(paramString).toLowerCase().endsWith(".number");
    AppMethodBeat.o(28207);
    return bool;
  }
  
  public final void a(File paramFile, List<String> paramList)
  {
    AppMethodBeat.i(28187);
    this.weq = paramFile;
    if ((this.weq != null) && (this.weq.canRead()) && (this.weq.isDirectory()))
    {
      this.wer = this.weq.listFiles(new FileFilter()
      {
        public final boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(28182);
          if (paramAnonymousFile.isHidden())
          {
            AppMethodBeat.o(28182);
            return false;
          }
          if ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymousFile.isDirectory()))
          {
            AppMethodBeat.o(28182);
            return false;
          }
          AppMethodBeat.o(28182);
          return true;
        }
      });
      if (this.wer == null) {
        this.wer = new File[0];
      }
      if (this.wer.length > 0)
      {
        a(this.wer);
        AppMethodBeat.o(28187);
      }
    }
    else if (paramList != null)
    {
      this.wer = new File[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        this.wer[i] = new File((String)paramList.get(i));
        this.wfq.add(this.wer[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(28187);
  }
  
  public final void c(File paramFile, boolean paramBoolean)
  {
    this.wfo = paramFile;
    this.wfp = paramBoolean;
  }
  
  public final int ces()
  {
    AppMethodBeat.i(28188);
    Iterator localIterator = this.wfq.iterator();
    File localFile;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(localFile.length() + l))
    {
      localFile = (File)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(28188);
    return i;
  }
  
  public final ArrayList<String> dpB()
  {
    AppMethodBeat.i(28189);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.wfq.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if ((!amG(localFile.getName())) && (!aH(localFile.getName()))) {
        localArrayList.add(localFile.getPath());
      }
    }
    AppMethodBeat.o(28189);
    return localArrayList;
  }
  
  public final ArrayList<String> dpC()
  {
    AppMethodBeat.i(28190);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.wfq.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if (amG(localFile.getName())) {
        localArrayList.add(localFile.getPath());
      }
    }
    AppMethodBeat.o(28190);
    return localArrayList;
  }
  
  public final ArrayList<String> dpD()
  {
    AppMethodBeat.i(28191);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.wfq.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if (aH(localFile.getName())) {
        localArrayList.add(localFile.getPath());
      }
    }
    AppMethodBeat.o(28191);
    return localArrayList;
  }
  
  public final File dpE()
  {
    AppMethodBeat.i(28192);
    if (this.weq.hashCode() == this.wfo.hashCode())
    {
      AppMethodBeat.o(28192);
      return null;
    }
    File localFile = this.weq.getParentFile();
    AppMethodBeat.o(28192);
    return localFile;
  }
  
  public final int getCount()
  {
    return this.wer.length;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    AppMethodBeat.i(28194);
    View localView = paramView;
    if (paramView == null)
    {
      localView = View.inflate(paramViewGroup.getContext(), 2130969604, null);
      paramView = new NewFileExplorerUI.a.b(this, (byte)0);
      paramView.wft = ((FrameLayout)localView.findViewById(2131824192));
      paramView.wfu = ((CheckBox)paramView.wft.findViewById(2131824194));
      paramView.ivs = ((ImageView)localView.findViewById(2131823589));
      paramView.gpL = ((TextView)localView.findViewById(2131823680));
      paramView.pMw = ((TextView)localView.findViewById(2131823435));
      paramView.ekh = ((TextView)localView.findViewById(2131824193));
      paramView.wft.setOnClickListener(new NewFileExplorerUI.a.4(this));
      localView.setTag(paramView);
    }
    paramViewGroup = (NewFileExplorerUI.a.b)localView.getTag();
    File localFile = this.wer[paramInt];
    paramViewGroup.gpL.setText(localFile.getName());
    int i;
    if (localFile.isDirectory())
    {
      paramViewGroup.ivs.setImageResource(2131230805);
      paramViewGroup.wft.setVisibility(4);
      paramViewGroup.pMw.setVisibility(0);
      paramViewGroup.ekh.setVisibility(8);
      paramView = localFile.list(new NewFileExplorerUI.a.5(this));
      if (paramView != null)
      {
        i = paramView.length;
        paramViewGroup.pMw.setText(this.wfn.getString(2131299876, new Object[] { Integer.valueOf(i) }));
      }
    }
    for (;;)
    {
      paramViewGroup.wfu.setChecked(this.wfq.contains(localFile));
      paramViewGroup.wft.setTag(Integer.valueOf(paramInt));
      AppMethodBeat.o(28194);
      return localView;
      i = 0;
      break;
      paramViewGroup.wft.setVisibility(0);
      paramViewGroup.pMw.setVisibility(0);
      paramViewGroup.ekh.setVisibility(0);
      paramViewGroup.pMw.setText(bo.hk(localFile.length()));
      paramViewGroup.ekh.setText(h.c(this.wfn, localFile.lastModified(), true));
      if (amG(localFile.getName()))
      {
        paramView = localFile.getPath();
        Cursor localCursor = this.wfn.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { paramView }, null);
        paramView = localObject;
        if (localCursor != null)
        {
          if (!localCursor.moveToFirst()) {
            break label505;
          }
          i = localCursor.getInt(localCursor.getColumnIndex("_id"));
          localCursor.close();
        }
        for (paramView = MediaStore.Images.Thumbnails.getThumbnail(this.wfn.getContentResolver(), i, 3, null);; paramView = localObject)
        {
          if (paramView == null) {
            break label518;
          }
          paramViewGroup.ivs.setImageBitmap(paramView);
          break;
          label505:
          localCursor.close();
        }
        label518:
        paramViewGroup.ivs.setImageResource(amF(localFile.getName()));
      }
      else
      {
        paramViewGroup.ivs.setImageResource(amF(localFile.getName()));
      }
    }
  }
  
  final class a
  {
    File file;
    long time;
    String wfs;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a
 * JD-Core Version:    0.7.0.1
 */