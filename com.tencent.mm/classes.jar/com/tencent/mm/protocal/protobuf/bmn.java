package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmn
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> EBv;
  public int FbM;
  public int FbN;
  public String FbO;
  public String md5;
  public String name;
  public String url;
  
  public bmn()
  {
    AppMethodBeat.i(82447);
    this.EBv = new LinkedList();
    AppMethodBeat.o(82447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.e(4, 1, this.EBv);
      paramVarArgs.aR(5, this.FbM);
      paramVarArgs.aR(6, this.FbN);
      if (this.FbO != null) {
        paramVarArgs.d(7, this.FbO);
      }
      AppMethodBeat.o(82448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label542;
      }
    }
    label542:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.a.c(4, 1, this.EBv) + f.a.a.b.b.a.bx(5, this.FbM) + f.a.a.b.b.a.bx(6, this.FbN);
      paramInt = i;
      if (this.FbO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FbO);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EBv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmn localbmn = (bmn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localbmn.name = locala.LVo.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localbmn.url = locala.LVo.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localbmn.md5 = locala.LVo.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localbmn.EBv.add(locala.LVo.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localbmn.FbM = locala.LVo.xF();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localbmn.FbN = locala.LVo.xF();
          AppMethodBeat.o(82448);
          return 0;
        }
        localbmn.FbO = locala.LVo.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmn
 * JD-Core Version:    0.7.0.1
 */