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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NewFileExplorerUI$a
  extends BaseAdapter
{
  private File slO;
  File[] slP = new File[0];
  private File smT;
  private boolean smU = false;
  private ArrayList<File> smV = new ArrayList();
  
  public NewFileExplorerUI$a(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  private static int WV(String paramString)
  {
    int j = 0;
    paramString = paramString.toLowerCase();
    String str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".doc")) || (str.endsWith(".docx")) || (str.endsWith("wps"))) {}
    for (int i = 1; i != 0; i = 0) {
      return R.k.app_attach_file_icon_word;
    }
    if (WW(paramString)) {
      return R.g.app_attach_file_icon_pic;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (i = 1; i != 0; i = 0) {
      return R.k.app_attach_file_icon_rar;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".txt")) || (str.endsWith(".rtf"))) {}
    for (i = 1; i != 0; i = 0) {
      return R.k.app_attach_file_icon_txt;
    }
    if (bk.pm(paramString).toLowerCase().endsWith(".pdf")) {
      return R.k.app_attach_file_icon_pdf;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".ppt")) || (str.endsWith(".pptx"))) {}
    for (i = 1; i != 0; i = 0) {
      return R.k.app_attach_file_icon_ppt;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".xls")) || (str.endsWith(".xlsx"))) {}
    for (i = 1; i != 0; i = 0) {
      return R.k.app_attach_file_icon_excel;
    }
    str = bk.pm(paramString).toLowerCase();
    if (!str.endsWith(".mp3"))
    {
      i = j;
      if (!str.endsWith(".wma")) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      return R.k.app_attach_file_icon_music;
    }
    if (aw(paramString)) {
      return R.k.app_attach_file_icon_video;
    }
    if (bk.pm(paramString).toLowerCase().endsWith(".html")) {
      return R.k.app_attach_file_icon_webpage;
    }
    if (bk.pm(paramString).toLowerCase().endsWith(".key")) {
      return R.k.app_attach_file_icon_keynote;
    }
    if (bk.pm(paramString).toLowerCase().endsWith(".number")) {
      return R.k.app_attach_file_icon_number;
    }
    if (bk.pm(paramString).toLowerCase().endsWith(".pages")) {
      return R.k.app_attach_file_icon_page;
    }
    return R.k.app_attach_file_icon_unknow;
  }
  
  private static boolean WW(String paramString)
  {
    paramString = bk.pm(paramString).toLowerCase();
    if ((Build.VERSION.SDK_INT >= 28) && (paramString.endsWith(".heic"))) {}
    while ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif"))) {
      return true;
    }
    return false;
  }
  
  static boolean aw(String paramString)
  {
    paramString = bk.pm(paramString).toLowerCase();
    return (paramString.endsWith(".mp4")) || (paramString.endsWith(".rm"));
  }
  
  public final void a(File paramFile, List<String> paramList)
  {
    this.slO = paramFile;
    if ((this.slO != null) && (this.slO.canRead()) && (this.slO.isDirectory()))
    {
      this.slP = this.slO.listFiles(new FileFilter()
      {
        public final boolean accept(File paramAnonymousFile)
        {
          if (paramAnonymousFile.isHidden()) {}
          while ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymousFile.isDirectory())) {
            return false;
          }
          return true;
        }
      });
      if (this.slP == null) {
        this.slP = new File[0];
      }
      if (this.slP.length > 0)
      {
        paramFile = this.slP;
        if ((paramFile != null) && (paramFile.length != 0)) {
          break label89;
        }
      }
    }
    for (;;)
    {
      return;
      label89:
      Object localObject1 = new ArrayList();
      paramList = new ArrayList();
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        Object localObject2 = paramFile[i];
        a locala = new a((byte)0);
        locala.file = localObject2;
        locala.time = localObject2.lastModified();
        if (localObject2.isDirectory())
        {
          locala.smX = g.oY(localObject2.getName()).toUpperCase();
          ((List)localObject1).add(locala);
        }
        for (;;)
        {
          i += 1;
          break;
          paramList.add(locala);
        }
      }
      Collections.sort((List)localObject1, new NewFileExplorerUI.a.2(this));
      Collections.sort(paramList, new NewFileExplorerUI.a.3(this));
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramFile[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramFile[i] = ((a)paramList.next()).file;
        i += 1;
      }
      continue;
      if (paramList != null)
      {
        this.slP = new File[paramList.size()];
        i = 0;
        while (i < paramList.size())
        {
          this.slP[i] = new File((String)paramList.get(i));
          this.smV.add(this.slP[i]);
          i += 1;
        }
      }
    }
  }
  
  public final int bug()
  {
    Iterator localIterator = this.smV.iterator();
    File localFile;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(localFile.length() + l))
    {
      localFile = (File)localIterator.next();
      l = i;
    }
    return i;
  }
  
  public final void c(File paramFile, boolean paramBoolean)
  {
    this.smT = paramFile;
    this.smU = paramBoolean;
  }
  
  public final ArrayList<String> com()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.smV.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if ((!WW(localFile.getName())) && (!aw(localFile.getName()))) {
        localArrayList.add(localFile.getPath());
      }
    }
    return localArrayList;
  }
  
  public final ArrayList<String> con()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.smV.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if (WW(localFile.getName())) {
        localArrayList.add(localFile.getPath());
      }
    }
    return localArrayList;
  }
  
  public final ArrayList<String> coo()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.smV.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if (aw(localFile.getName())) {
        localArrayList.add(localFile.getPath());
      }
    }
    return localArrayList;
  }
  
  public final File cop()
  {
    if (this.slO.hashCode() == this.smT.hashCode()) {
      return null;
    }
    return this.slO.getParentFile();
  }
  
  public final int getCount()
  {
    return this.slP.length;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    View localView = paramView;
    if (paramView == null)
    {
      localView = View.inflate(paramViewGroup.getContext(), R.i.fm_file_item, null);
      paramView = new NewFileExplorerUI.a.b(this, (byte)0);
      paramView.smY = ((FrameLayout)localView.findViewById(R.h.item_selector_wrapper));
      paramView.smZ = ((CheckBox)paramView.smY.findViewById(R.h.item_selector));
      paramView.gSx = ((ImageView)localView.findViewById(R.h.item_icon));
      paramView.eXO = ((TextView)localView.findViewById(R.h.item_title));
      paramView.nhj = ((TextView)localView.findViewById(R.h.item_size));
      paramView.dsz = ((TextView)localView.findViewById(R.h.item_time));
      paramView.smY.setOnClickListener(new NewFileExplorerUI.a.4(this));
      localView.setTag(paramView);
    }
    paramViewGroup = (NewFileExplorerUI.a.b)localView.getTag();
    File localFile = this.slP[paramInt];
    paramViewGroup.eXO.setText(localFile.getName());
    int i;
    if (localFile.isDirectory())
    {
      paramViewGroup.gSx.setImageResource(R.k.app_attach_file_icon_folders);
      paramViewGroup.smY.setVisibility(4);
      paramViewGroup.nhj.setVisibility(0);
      paramViewGroup.dsz.setVisibility(8);
      paramView = localFile.list(new NewFileExplorerUI.a.5(this));
      if (paramView != null)
      {
        i = paramView.length;
        paramViewGroup.nhj.setText(this.smS.getString(R.l.file_explorer_dir_subfile_size, new Object[] { Integer.valueOf(i) }));
      }
    }
    for (;;)
    {
      paramViewGroup.smZ.setChecked(this.smV.contains(localFile));
      paramViewGroup.smY.setTag(Integer.valueOf(paramInt));
      return localView;
      i = 0;
      break;
      paramViewGroup.smY.setVisibility(0);
      paramViewGroup.nhj.setVisibility(0);
      paramViewGroup.dsz.setVisibility(0);
      paramViewGroup.nhj.setText(bk.cm(localFile.length()));
      paramViewGroup.dsz.setText(h.c(this.smS, localFile.lastModified(), true));
      if (WW(localFile.getName()))
      {
        paramView = localFile.getPath();
        Cursor localCursor = this.smS.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { paramView }, null);
        paramView = localObject;
        if (localCursor != null)
        {
          if (!localCursor.moveToFirst()) {
            break label493;
          }
          i = localCursor.getInt(localCursor.getColumnIndex("_id"));
          localCursor.close();
        }
        for (paramView = MediaStore.Images.Thumbnails.getThumbnail(this.smS.getContentResolver(), i, 3, null);; paramView = localObject)
        {
          if (paramView == null) {
            break label506;
          }
          paramViewGroup.gSx.setImageBitmap(paramView);
          break;
          label493:
          localCursor.close();
        }
        label506:
        paramViewGroup.gSx.setImageResource(WV(localFile.getName()));
      }
      else
      {
        paramViewGroup.gSx.setImageResource(WV(localFile.getName()));
      }
    }
  }
  
  private final class a
  {
    File file;
    String smX;
    long time;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a
 * JD-Core Version:    0.7.0.1
 */