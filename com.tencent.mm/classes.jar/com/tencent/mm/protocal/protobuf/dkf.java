package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkf
  extends com.tencent.mm.bw.a
{
  public String DcW;
  public int Gwu;
  public long HRX;
  public boolean HRY;
  public LinkedList<String> HRZ;
  public LinkedList<String> HSa;
  public int xOV;
  
  public dkf()
  {
    AppMethodBeat.i(118452);
    this.HRZ = new LinkedList();
    this.HSa = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HRX);
      paramVarArgs.aS(2, this.xOV);
      paramVarArgs.aS(3, this.Gwu);
      paramVarArgs.bC(4, this.HRY);
      paramVarArgs.e(5, 1, this.HRZ);
      paramVarArgs.e(6, 1, this.HSa);
      if (this.DcW != null) {
        paramVarArgs.d(7, this.DcW);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.HRX) + 0 + f.a.a.b.b.a.bz(2, this.xOV) + f.a.a.b.b.a.bz(3, this.Gwu) + f.a.a.b.b.a.amF(4) + f.a.a.a.c(5, 1, this.HRZ) + f.a.a.a.c(6, 1, this.HSa);
      paramInt = i;
      if (this.DcW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DcW);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HRZ.clear();
      this.HSa.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkf localdkf = (dkf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localdkf.HRX = locala.OmT.zd();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localdkf.xOV = locala.OmT.zc();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localdkf.Gwu = locala.OmT.zc();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localdkf.HRY = locala.OmT.gvY();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localdkf.HRZ.add(locala.OmT.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localdkf.HSa.add(locala.OmT.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localdkf.DcW = locala.OmT.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */