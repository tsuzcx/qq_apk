package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgr
  extends com.tencent.mm.bx.a
{
  public LinkedList<epb> ZQf;
  public int mIY;
  public int mIZ;
  public int mJa;
  public int mJb;
  
  public bgr()
  {
    AppMethodBeat.i(257948);
    this.ZQf = new LinkedList();
    AppMethodBeat.o(257948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257953);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.mIY);
      paramVarArgs.bS(2, this.mIZ);
      paramVarArgs.bS(3, this.mJa);
      paramVarArgs.bS(4, this.mJb);
      paramVarArgs.e(5, 8, this.ZQf);
      AppMethodBeat.o(257953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.mIY);
      i = i.a.a.b.b.a.cJ(2, this.mIZ);
      int j = i.a.a.b.b.a.cJ(3, this.mJa);
      int k = i.a.a.b.b.a.cJ(4, this.mJb);
      int m = i.a.a.a.c(5, 8, this.ZQf);
      AppMethodBeat.o(257953);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZQf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bgr localbgr = (bgr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257953);
        return -1;
      case 1: 
        localbgr.mIY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257953);
        return 0;
      case 2: 
        localbgr.mIZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257953);
        return 0;
      case 3: 
        localbgr.mJa = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257953);
        return 0;
      case 4: 
        localbgr.mJb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257953);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        epb localepb = new epb();
        if ((localObject != null) && (localObject.length > 0)) {
          localepb.parseFrom((byte[])localObject);
        }
        localbgr.ZQf.add(localepb);
        paramInt += 1;
      }
      AppMethodBeat.o(257953);
      return 0;
    }
    AppMethodBeat.o(257953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgr
 * JD-Core Version:    0.7.0.1
 */