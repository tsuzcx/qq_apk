package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqa
  extends erp
{
  public String Oln;
  public String Olo;
  public String YAg;
  public String abPH;
  public String abPo;
  public String abPp;
  public int amount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YAg != null) {
        paramVarArgs.g(2, this.YAg);
      }
      if (this.Oln != null) {
        paramVarArgs.g(3, this.Oln);
      }
      if (this.abPo != null) {
        paramVarArgs.g(4, this.abPo);
      }
      if (this.abPp != null) {
        paramVarArgs.g(5, this.abPp);
      }
      paramVarArgs.bS(6, this.amount);
      if (this.abPH != null) {
        paramVarArgs.g(7, this.abPH);
      }
      if (this.Olo != null) {
        paramVarArgs.g(8, this.Olo);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label696;
      }
    }
    label696:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YAg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YAg);
      }
      i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Oln);
      }
      paramInt = i;
      if (this.abPo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abPo);
      }
      i = paramInt;
      if (this.abPp != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abPp);
      }
      i += i.a.a.b.b.a.cJ(6, this.amount);
      paramInt = i;
      if (this.abPH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abPH);
      }
      i = paramInt;
      if (this.Olo != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Olo);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fqa localfqa = (fqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localfqa.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localfqa.YAg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localfqa.Oln = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localfqa.abPo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localfqa.abPp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localfqa.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localfqa.abPH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localfqa.Olo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqa
 * JD-Core Version:    0.7.0.1
 */