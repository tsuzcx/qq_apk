package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayk
  extends ckq
{
  public String Ctm;
  public String ddU;
  public String dgo;
  public String rht;
  public String rhu;
  public String rhv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ddU != null) {
        paramVarArgs.d(2, this.ddU);
      }
      if (this.rht != null) {
        paramVarArgs.d(3, this.rht);
      }
      if (this.rhu != null) {
        paramVarArgs.d(4, this.rhu);
      }
      if (this.rhv != null) {
        paramVarArgs.d(5, this.rhv);
      }
      if (this.dgo != null) {
        paramVarArgs.d(6, this.dgo);
      }
      if (this.Ctm != null) {
        paramVarArgs.d(7, this.Ctm);
      }
      AppMethodBeat.o(32262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ddU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ddU);
      }
      i = paramInt;
      if (this.rht != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rht);
      }
      paramInt = i;
      if (this.rhu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rhu);
      }
      i = paramInt;
      if (this.rhv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rhv);
      }
      paramInt = i;
      if (this.dgo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dgo);
      }
      i = paramInt;
      if (this.Ctm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ctm);
      }
      AppMethodBeat.o(32262);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayk localayk = (ayk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32262);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32262);
          return 0;
        case 2: 
          localayk.ddU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 3: 
          localayk.rht = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 4: 
          localayk.rhu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 5: 
          localayk.rhv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 6: 
          localayk.dgo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32262);
          return 0;
        }
        localayk.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32262);
        return 0;
      }
      AppMethodBeat.o(32262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayk
 * JD-Core Version:    0.7.0.1
 */