package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class erf
  extends com.tencent.mm.cd.a
{
  public String IbE;
  public int Ibx;
  public int IcW;
  public ajc IcZ;
  public fbn Sdr;
  public String text;
  public int textColor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140931);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.text == null)
      {
        paramVarArgs = new b("Not all required fields were included: text");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.f(1, this.text);
      }
      paramVarArgs.aY(2, this.textColor);
      paramVarArgs.aY(3, this.IcW);
      if (this.Sdr != null)
      {
        paramVarArgs.oE(4, this.Sdr.computeSize());
        this.Sdr.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Ibx);
      if (this.IcZ != null)
      {
        paramVarArgs.oE(6, this.IcZ.computeSize());
        this.IcZ.writeFields(paramVarArgs);
      }
      if (this.IbE != null) {
        paramVarArgs.f(7, this.IbE);
      }
      AppMethodBeat.o(140931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = g.a.a.b.b.a.g(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.textColor) + g.a.a.b.b.a.bM(3, this.IcW);
      paramInt = i;
      if (this.Sdr != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sdr.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Ibx);
      paramInt = i;
      if (this.IcZ != null) {
        paramInt = i + g.a.a.a.oD(6, this.IcZ.computeSize());
      }
      i = paramInt;
      if (this.IbE != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.IbE);
      }
      AppMethodBeat.o(140931);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.Sdr == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        erf localerf = (erf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localerf.text = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localerf.textColor = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localerf.IcW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbn)localObject2).parseFrom((byte[])localObject1);
            }
            localerf.Sdr = ((fbn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        case 5: 
          localerf.Ibx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(140931);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ajc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ajc)localObject2).parseFrom((byte[])localObject1);
            }
            localerf.IcZ = ((ajc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localerf.IbE = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erf
 * JD-Core Version:    0.7.0.1
 */