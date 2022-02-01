package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class blm
  extends cpx
{
  public crm DPA;
  public LinkedList<bud> DPz;
  public int Fbb;
  public String Fbc;
  public int fsB;
  
  public blm()
  {
    AppMethodBeat.i(101819);
    this.DPz = new LinkedList();
    AppMethodBeat.o(101819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101820);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fsB);
      paramVarArgs.e(3, 8, this.DPz);
      if (this.DPA != null)
      {
        paramVarArgs.ln(4, this.DPA.computeSize());
        this.DPA.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Fbb);
      if (this.Fbc != null) {
        paramVarArgs.d(6, this.Fbc);
      }
      AppMethodBeat.o(101820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.fsB) + f.a.a.a.c(3, 8, this.DPz);
      paramInt = i;
      if (this.DPA != null) {
        paramInt = i + f.a.a.a.lm(4, this.DPA.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Fbb);
      paramInt = i;
      if (this.Fbc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fbc);
      }
      AppMethodBeat.o(101820);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DPz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DPA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blm localblm = (blm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101820);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 2: 
          localblm.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101820);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bud();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bud)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblm.DPz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblm.DPA = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 5: 
          localblm.Fbb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101820);
          return 0;
        }
        localblm.Fbc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(101820);
        return 0;
      }
      AppMethodBeat.o(101820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blm
 * JD-Core Version:    0.7.0.1
 */