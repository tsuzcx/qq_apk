package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpy
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> DOh;
  public boolean zEm;
  public String zEn;
  
  public bpy()
  {
    AppMethodBeat.i(91541);
    this.DOh = new LinkedList();
    AppMethodBeat.o(91541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.zEm);
      if (this.zEn != null) {
        paramVarArgs.d(2, this.zEn);
      }
      paramVarArgs.e(3, 2, this.DOh);
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0;
      paramInt = i;
      if (this.zEn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.zEn);
      }
      i = f.a.a.a.c(3, 2, this.DOh);
      AppMethodBeat.o(91542);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DOh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpy localbpy = (bpy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91542);
        return -1;
      case 1: 
        localbpy.zEm = locala.KhF.fHu();
        AppMethodBeat.o(91542);
        return 0;
      case 2: 
        localbpy.zEn = locala.KhF.readString();
        AppMethodBeat.o(91542);
        return 0;
      }
      localbpy.DOh.add(Integer.valueOf(locala.KhF.xS()));
      AppMethodBeat.o(91542);
      return 0;
    }
    AppMethodBeat.o(91542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpy
 * JD-Core Version:    0.7.0.1
 */