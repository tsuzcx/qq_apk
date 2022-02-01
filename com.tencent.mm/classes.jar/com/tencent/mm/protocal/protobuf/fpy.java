package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpy
  extends erp
{
  public String abPC;
  public int abPI;
  public String abPJ;
  public String abPo;
  public String abPp;
  public String abPq;
  public String abPs;
  public int amount;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72607);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abPo != null) {
        paramVarArgs.g(2, this.abPo);
      }
      if (this.abPp != null) {
        paramVarArgs.g(3, this.abPp);
      }
      if (this.abPq != null) {
        paramVarArgs.g(4, this.abPq);
      }
      paramVarArgs.bS(5, this.amount);
      if (this.desc != null) {
        paramVarArgs.g(6, this.desc);
      }
      paramVarArgs.bS(7, this.abPI);
      if (this.abPs != null) {
        paramVarArgs.g(8, this.abPs);
      }
      if (this.abPC != null) {
        paramVarArgs.g(9, this.abPC);
      }
      if (this.abPJ != null) {
        paramVarArgs.g(10, this.abPJ);
      }
      AppMethodBeat.o(72607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label804;
      }
    }
    label804:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abPo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abPo);
      }
      i = paramInt;
      if (this.abPp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abPp);
      }
      paramInt = i;
      if (this.abPq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abPq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.amount);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.desc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.abPI);
      paramInt = i;
      if (this.abPs != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abPs);
      }
      i = paramInt;
      if (this.abPC != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abPC);
      }
      paramInt = i;
      if (this.abPJ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abPJ);
      }
      AppMethodBeat.o(72607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fpy localfpy = (fpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72607);
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
            localfpy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72607);
          return 0;
        case 2: 
          localfpy.abPo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 3: 
          localfpy.abPp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 4: 
          localfpy.abPq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 5: 
          localfpy.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72607);
          return 0;
        case 6: 
          localfpy.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 7: 
          localfpy.abPI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72607);
          return 0;
        case 8: 
          localfpy.abPs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 9: 
          localfpy.abPC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72607);
          return 0;
        }
        localfpy.abPJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72607);
        return 0;
      }
      AppMethodBeat.o(72607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpy
 * JD-Core Version:    0.7.0.1
 */