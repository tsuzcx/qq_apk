package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vr
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> CXK;
  public String CXL;
  public long CXM;
  public int mBH;
  
  public vr()
  {
    AppMethodBeat.i(6401);
    this.CXK = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      paramVarArgs.e(2, 1, this.CXK);
      if (this.CXL != null) {
        paramVarArgs.d(3, this.CXL);
      }
      paramVarArgs.aG(4, this.CXM);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mBH) + 0 + f.a.a.a.c(2, 1, this.CXK);
      paramInt = i;
      if (this.CXL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CXL);
      }
      i = f.a.a.b.b.a.q(4, this.CXM);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CXK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vr localvr = (vr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localvr.mBH = locala.KhF.xS();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localvr.CXK.add(locala.KhF.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localvr.CXL = locala.KhF.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localvr.CXM = locala.KhF.xT();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */