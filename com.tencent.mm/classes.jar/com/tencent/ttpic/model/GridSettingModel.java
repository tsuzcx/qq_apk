package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class GridSettingModel
{
  public Rect canvasRect;
  public List<GridModel> canvasRectList;
  
  public GridSettingModel()
  {
    AppMethodBeat.i(83498);
    this.canvasRect = new Rect();
    this.canvasRectList = new ArrayList();
    AppMethodBeat.o(83498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.GridSettingModel
 * JD-Core Version:    0.7.0.1
 */