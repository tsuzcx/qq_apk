package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bw.a
{
  public String DLs;
  public String DLt;
  public String DLu;
  public String DLv;
  public LinkedList<String> DLw;
  public String ncW;
  public String ndw;
  
  public aa()
  {
    AppMethodBeat.i(145665);
    this.DLw = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndw != null) {
        paramVarArgs.d(1, this.ndw);
      }
      if (this.ncW != null) {
        paramVarArgs.d(2, this.ncW);
      }
      if (this.DLs != null) {
        paramVarArgs.d(3, this.DLs);
      }
      if (this.DLt != null) {
        paramVarArgs.d(4, this.DLt);
      }
      if (this.DLu != null) {
        paramVarArgs.d(5, this.DLu);
      }
      if (this.DLv != null) {
        paramVarArgs.d(6, this.DLv);
      }
      paramVarArgs.e(7, 1, this.DLw);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndw == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.ndw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncW);
      }
      i = paramInt;
      if (this.DLs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DLs);
      }
      paramInt = i;
      if (this.DLt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLt);
      }
      i = paramInt;
      if (this.DLu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DLu);
      }
      paramInt = i;
      if (this.DLv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DLv);
      }
      i = f.a.a.a.c(7, 1, this.DLw);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DLw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localaa.ndw = locala.LVo.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localaa.ncW = locala.LVo.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localaa.DLs = locala.LVo.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localaa.DLt = locala.LVo.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localaa.DLu = locala.LVo.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localaa.DLv = locala.LVo.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localaa.DLw.add(locala.LVo.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */