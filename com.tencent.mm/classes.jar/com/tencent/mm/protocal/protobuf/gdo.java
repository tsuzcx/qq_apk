package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gdo
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> YMV;
  public long acbt;
  public int acbu;
  public SnsObject acbv;
  
  public gdo()
  {
    AppMethodBeat.i(260217);
    this.YMV = new LinkedList();
    AppMethodBeat.o(260217);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260221);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.acbt);
      paramVarArgs.bS(2, this.acbu);
      if (this.acbv != null)
      {
        paramVarArgs.qD(3, this.acbv.computeSize());
        this.acbv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 3, this.YMV);
      AppMethodBeat.o(260221);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.acbt) + 0 + i.a.a.b.b.a.cJ(2, this.acbu);
      paramInt = i;
      if (this.acbv != null) {
        paramInt = i + i.a.a.a.qC(3, this.acbv.computeSize());
      }
      i = i.a.a.a.c(4, 3, this.YMV);
      AppMethodBeat.o(260221);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YMV.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260221);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gdo localgdo = (gdo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260221);
        return -1;
      case 1: 
        localgdo.acbt = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(260221);
        return 0;
      case 2: 
        localgdo.acbu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260221);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          SnsObject localSnsObject = new SnsObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localSnsObject.parseFrom((byte[])localObject);
          }
          localgdo.acbv = localSnsObject;
          paramInt += 1;
        }
        AppMethodBeat.o(260221);
        return 0;
      }
      localgdo.YMV.add(Long.valueOf(((i.a.a.a.a)localObject).ajGk.aaw()));
      AppMethodBeat.o(260221);
      return 0;
    }
    AppMethodBeat.o(260221);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdo
 * JD-Core Version:    0.7.0.1
 */