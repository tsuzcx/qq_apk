package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gkr
  extends com.tencent.mm.bx.a
{
  public String abBw;
  public boolean acfZ;
  public int acgA;
  public boolean acgb;
  public boolean acgc;
  public String acgx;
  public fbt acgy;
  public fnp acgz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acgx != null) {
        paramVarArgs.g(1, this.acgx);
      }
      if (this.abBw != null) {
        paramVarArgs.g(2, this.abBw);
      }
      if (this.acgy != null)
      {
        paramVarArgs.qD(3, this.acgy.computeSize());
        this.acgy.writeFields(paramVarArgs);
      }
      paramVarArgs.di(4, this.acfZ);
      paramVarArgs.di(5, this.acgb);
      if (this.acgz != null)
      {
        paramVarArgs.qD(6, this.acgz.computeSize());
        this.acgz.writeFields(paramVarArgs);
      }
      paramVarArgs.di(7, this.acgc);
      paramVarArgs.bS(8, this.acgA);
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acgx == null) {
        break label714;
      }
    }
    label714:
    for (int i = i.a.a.b.b.a.h(1, this.acgx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abBw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abBw);
      }
      i = paramInt;
      if (this.acgy != null) {
        i = paramInt + i.a.a.a.qC(3, this.acgy.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.acgz != null) {
        paramInt = i + i.a.a.a.qC(6, this.acgz.computeSize());
      }
      i = i.a.a.b.b.a.ko(7);
      int j = i.a.a.b.b.a.cJ(8, this.acgA);
      AppMethodBeat.o(153317);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gkr localgkr = (gkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localgkr.acgx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localgkr.abBw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbt)localObject2).parseFrom((byte[])localObject1);
            }
            localgkr.acgy = ((fbt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localgkr.acfZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localgkr.acgb = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153317);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnp)localObject2).parseFrom((byte[])localObject1);
            }
            localgkr.acgz = ((fnp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 7: 
          localgkr.acgc = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153317);
          return 0;
        }
        localgkr.acgA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkr
 * JD-Core Version:    0.7.0.1
 */