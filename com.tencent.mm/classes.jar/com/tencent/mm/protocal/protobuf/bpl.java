package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpl
  extends com.tencent.mm.bw.a
{
  public PersonalDesigner EOk;
  public String Ewy;
  public bpk FeL;
  public bpn FeM;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104818);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ewy != null) {
        paramVarArgs.d(1, this.Ewy);
      }
      if (this.FeL != null)
      {
        paramVarArgs.ln(2, this.FeL.computeSize());
        this.FeL.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.EOk != null)
      {
        paramVarArgs.ln(4, this.EOk.computeSize());
        this.EOk.writeFields(paramVarArgs);
      }
      if (this.FeM != null)
      {
        paramVarArgs.ln(5, this.FeM.computeSize());
        this.FeM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ewy == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Ewy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FeL != null) {
        paramInt = i + f.a.a.a.lm(2, this.FeL.computeSize());
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.EOk != null) {
        paramInt = i + f.a.a.a.lm(4, this.EOk.computeSize());
      }
      i = paramInt;
      if (this.FeM != null) {
        i = paramInt + f.a.a.a.lm(5, this.FeM.computeSize());
      }
      AppMethodBeat.o(104818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpl localbpl = (bpl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104818);
          return -1;
        case 1: 
          localbpl.Ewy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpl.FeL = ((bpk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        case 3: 
          localbpl.Name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104818);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PersonalDesigner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpl.EOk = ((PersonalDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104818);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpl.FeM = ((bpn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104818);
        return 0;
      }
      AppMethodBeat.o(104818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpl
 * JD-Core Version:    0.7.0.1
 */