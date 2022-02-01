package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ago
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public String YMe;
  public LinkedList<fmp> Zdm;
  public LinkedList<fmp> ZpK;
  public String ZpL;
  public int state;
  
  public ago()
  {
    AppMethodBeat.i(91427);
    this.Zdm = new LinkedList();
    this.ZpK = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.state);
      if (this.YCT != null)
      {
        paramVarArgs.qD(2, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Zdm);
      paramVarArgs.e(4, 8, this.ZpK);
      if (this.ZpL != null) {
        paramVarArgs.g(5, this.ZpL);
      }
      if (this.YMe != null) {
        paramVarArgs.g(6, this.YMe);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.state) + 0;
      paramInt = i;
      if (this.YCT != null) {
        paramInt = i + i.a.a.a.qC(2, this.YCT.computeSize());
      }
      i = paramInt + i.a.a.a.c(3, 8, this.Zdm) + i.a.a.a.c(4, 8, this.ZpK);
      paramInt = i;
      if (this.ZpL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZpL);
      }
      i = paramInt;
      if (this.YMe != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YMe);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zdm.clear();
      this.ZpK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ago localago = (ago)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fmp localfmp;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localago.state = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfmp = new fmp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmp.parseFrom((byte[])localObject);
          }
          localago.YCT = localfmp;
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfmp = new fmp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmp.parseFrom((byte[])localObject);
          }
          localago.Zdm.add(localfmp);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfmp = new fmp();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmp.parseFrom((byte[])localObject);
          }
          localago.ZpK.add(localfmp);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localago.ZpL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localago.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ago
 * JD-Core Version:    0.7.0.1
 */