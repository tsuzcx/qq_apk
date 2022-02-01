package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddc
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public fmp aaIG;
  public LinkedList<fll> aaIH;
  public fmp aaII;
  
  public ddc()
  {
    AppMethodBeat.i(91526);
    this.aaIH = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaIG != null)
      {
        paramVarArgs.qD(1, this.aaIG.computeSize());
        this.aaIG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaIH);
      if (this.aaII != null)
      {
        paramVarArgs.qD(3, this.aaII.computeSize());
        this.aaII.writeFields(paramVarArgs);
      }
      if (this.YMe != null) {
        paramVarArgs.g(4, this.YMe);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaIG == null) {
        break label596;
      }
    }
    label596:
    for (paramInt = i.a.a.a.qC(1, this.aaIG.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaIH);
      paramInt = i;
      if (this.aaII != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaII.computeSize());
      }
      i = paramInt;
      if (this.YMe != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YMe);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaIH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ddc localddc = (ddc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localddc.aaIG = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fll();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fll)localObject2).parseFrom((byte[])localObject1);
            }
            localddc.aaIH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localddc.aaII = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localddc.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddc
 * JD-Core Version:    0.7.0.1
 */