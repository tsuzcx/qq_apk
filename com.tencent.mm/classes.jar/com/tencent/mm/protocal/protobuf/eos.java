package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eos
  extends erp
{
  public int ZwS;
  public String ZwU;
  public String ZwV;
  public String aayT;
  public String absU;
  public String absV;
  public String vhX;
  public String ytj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259458);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.ytj != null) {
        paramVarArgs.g(3, this.ytj);
      }
      paramVarArgs.bS(4, this.ZwS);
      if (this.ZwU != null) {
        paramVarArgs.g(5, this.ZwU);
      }
      if (this.ZwV != null) {
        paramVarArgs.g(6, this.ZwV);
      }
      if (this.absU != null) {
        paramVarArgs.g(7, this.absU);
      }
      if (this.aayT != null) {
        paramVarArgs.g(8, this.aayT);
      }
      if (this.absV != null) {
        paramVarArgs.g(9, this.absV);
      }
      AppMethodBeat.o(259458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label756;
      }
    }
    label756:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.ytj != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ytj);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZwS);
      paramInt = i;
      if (this.ZwU != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZwU);
      }
      i = paramInt;
      if (this.ZwV != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZwV);
      }
      paramInt = i;
      if (this.absU != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.absU);
      }
      i = paramInt;
      if (this.aayT != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aayT);
      }
      paramInt = i;
      if (this.absV != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.absV);
      }
      AppMethodBeat.o(259458);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eos localeos = (eos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259458);
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
            localeos.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259458);
          return 0;
        case 2: 
          localeos.vhX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259458);
          return 0;
        case 3: 
          localeos.ytj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259458);
          return 0;
        case 4: 
          localeos.ZwS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259458);
          return 0;
        case 5: 
          localeos.ZwU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259458);
          return 0;
        case 6: 
          localeos.ZwV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259458);
          return 0;
        case 7: 
          localeos.absU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259458);
          return 0;
        case 8: 
          localeos.aayT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259458);
          return 0;
        }
        localeos.absV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259458);
        return 0;
      }
      AppMethodBeat.o(259458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eos
 * JD-Core Version:    0.7.0.1
 */