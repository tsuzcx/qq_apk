package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dud
  extends com.tencent.mm.bw.a
{
  public dtz Gcb;
  public dtp Gcc;
  public String Gcd;
  public String Gce;
  public String Gcf;
  public int Gcg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gcb != null)
      {
        paramVarArgs.ln(1, this.Gcb.computeSize());
        this.Gcb.writeFields(paramVarArgs);
      }
      if (this.Gcc != null)
      {
        paramVarArgs.ln(2, this.Gcc.computeSize());
        this.Gcc.writeFields(paramVarArgs);
      }
      if (this.Gcd != null) {
        paramVarArgs.d(3, this.Gcd);
      }
      if (this.Gce != null) {
        paramVarArgs.d(4, this.Gce);
      }
      if (this.Gcf != null) {
        paramVarArgs.d(5, this.Gcf);
      }
      paramVarArgs.aR(6, this.Gcg);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gcb == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lm(1, this.Gcb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gcc != null) {
        paramInt = i + f.a.a.a.lm(2, this.Gcc.computeSize());
      }
      i = paramInt;
      if (this.Gcd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gcd);
      }
      paramInt = i;
      if (this.Gce != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gce);
      }
      i = paramInt;
      if (this.Gcf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gcf);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.Gcg);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dud localdud = (dud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdud.Gcb = ((dtz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdud.Gcc = ((dtp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localdud.Gcd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localdud.Gce = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localdud.Gcf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localdud.Gcg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dud
 * JD-Core Version:    0.7.0.1
 */