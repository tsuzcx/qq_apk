package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bmp
  extends com.tencent.mm.bx.a
{
  public dks DKf;
  public float dpb;
  public float dqQ;
  public String goP;
  public String goQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.goP == null)
      {
        paramVarArgs = new b("Not all required fields were included: cityName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.goQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: poiName");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.DKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140927);
        throw paramVarArgs;
      }
      if (this.goP != null) {
        paramVarArgs.d(1, this.goP);
      }
      if (this.goQ != null) {
        paramVarArgs.d(2, this.goQ);
      }
      if (this.DKf != null)
      {
        paramVarArgs.kX(4, this.DKf.computeSize());
        this.DKf.writeFields(paramVarArgs);
      }
      paramVarArgs.x(5, this.dqQ);
      paramVarArgs.x(6, this.dpb);
      AppMethodBeat.o(140927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.goP == null) {
        break label672;
      }
    }
    label672:
    for (int i = f.a.a.b.b.a.e(1, this.goP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.goQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.goQ);
      }
      i = paramInt;
      if (this.DKf != null) {
        i = paramInt + f.a.a.a.kW(4, this.DKf.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(5);
      int j = f.a.a.b.b.a.fY(6);
      AppMethodBeat.o(140927);
      return i + (paramInt + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.goP == null)
        {
          paramVarArgs = new b("Not all required fields were included: cityName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.goQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: poiName");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        if (this.DKf == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmp localbmp = (bmp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(140927);
          return -1;
        case 1: 
          localbmp.goP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 2: 
          localbmp.goQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(140927);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmp.DKf = ((dks)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(140927);
          return 0;
        case 5: 
          localbmp.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(140927);
          return 0;
        }
        localbmp.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
        AppMethodBeat.o(140927);
        return 0;
      }
      AppMethodBeat.o(140927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmp
 * JD-Core Version:    0.7.0.1
 */