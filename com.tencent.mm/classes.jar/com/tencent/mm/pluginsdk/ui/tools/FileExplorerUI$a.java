package com.tencent.mm.pluginsdk.ui.tools;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class FileExplorerUI$a
  extends BaseAdapter
{
  String eFm;
  private File slN;
  private File slO;
  private File[] slP;
  
  private FileExplorerUI$a(FileExplorerUI paramFileExplorerUI) {}
  
  public final void g(File paramFile1, File paramFile2)
  {
    this.slN = paramFile1;
    if (paramFile2.getAbsolutePath().equalsIgnoreCase(this.eFm)) {
      this.slN = null;
    }
    this.slO = paramFile2;
    if ((this.slO.canRead()) && (this.slO.isDirectory()))
    {
      this.slP = this.slO.listFiles(new FileExplorerUI.a.1(this));
      if (this.slP == null) {
        this.slP = new File[0];
      }
      if (this.slP.length > 0)
      {
        paramFile1 = this.slP;
        if ((paramFile1 != null) && (paramFile1.length != 0)) {
          break label106;
        }
      }
      for (;;)
      {
        return;
        label106:
        Object localObject1 = new ArrayList();
        paramFile2 = new ArrayList();
        int j = paramFile1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = paramFile1[i];
          FileExplorerUI.b localb = new FileExplorerUI.b(this.slK, (byte)0);
          localb.file = localObject2;
          localb.slR = g.oY(localObject2.getName()).toUpperCase();
          if (localObject2.isDirectory()) {
            ((List)localObject1).add(localb);
          }
          for (;;)
          {
            i += 1;
            break;
            paramFile2.add(localb);
          }
        }
        Collections.sort((List)localObject1, new FileExplorerUI.a.2(this));
        Collections.sort(paramFile2, new FileExplorerUI.a.3(this));
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          paramFile1[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).file;
          i += 1;
        }
        paramFile2 = paramFile2.iterator();
        while (paramFile2.hasNext())
        {
          paramFile1[i] = ((FileExplorerUI.b)paramFile2.next()).file;
          i += 1;
        }
      }
    }
    this.slP = new File[0];
  }
  
  public final int getCount()
  {
    int i = 0;
    if (this.slP == null) {
      return 0;
    }
    int j = this.slP.length;
    if (this.slN != null) {
      i = 1;
    }
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    if ((this.slN != null) && (paramInt == 0)) {
      return this.slN;
    }
    y.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.slP.length);
    File[] arrayOfFile = this.slP;
    if (this.slN == null) {}
    for (;;)
    {
      return arrayOfFile[paramInt];
      paramInt -= 1;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.slK, a.h.mail_file_explorer_item, null);
      paramView = new FileExplorerUI.c(this.slK, (byte)0);
      paramView.gSx = ((ImageView)paramViewGroup.findViewById(a.g.file_icon_iv));
      paramView.fhD = ((TextView)paramViewGroup.findViewById(a.g.file_name_tv));
      paramView.slS = ((TextView)paramViewGroup.findViewById(a.g.file_summary_tv));
      paramViewGroup.setTag(paramView);
    }
    Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
    paramView = (File)getItem(paramInt);
    if (paramView == this.slN)
    {
      ((FileExplorerUI.c)localObject).fhD.setText(paramView.getName());
      ((FileExplorerUI.c)localObject).gSx.setImageResource(a.f.qqmail_attach_back);
      ((FileExplorerUI.c)localObject).slS.setVisibility(0);
      return paramViewGroup;
    }
    ((FileExplorerUI.c)localObject).gSx.setImageResource(FileExplorerUI.M(paramView));
    ((FileExplorerUI.c)localObject).fhD.setText(paramView.getName());
    localObject = ((FileExplorerUI.c)localObject).slS;
    StringBuilder localStringBuilder = new StringBuilder().append(DateFormat.format("yyyy-MM-dd hh:mm:ss", paramView.lastModified()).toString());
    if (paramView.isDirectory()) {}
    for (paramView = "";; paramView = "  " + bk.cm(paramView.length()))
    {
      ((TextView)localObject).setText(paramView);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a
 * JD-Core Version:    0.7.0.1
 */