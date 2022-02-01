package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etb
  extends erp
{
  public String YFk;
  public etd abwr;
  public String abws;
  public String abwt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181510);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YFk != null) {
        paramVarArgs.g(2, this.YFk);
      }
      if (this.abws != null) {
        paramVarArgs.g(3, this.abws);
      }
      if (this.abwt != null) {
        paramVarArgs.g(4, this.abwt);
      }
      if (this.abwr != null)
      {
        paramVarArgs.qD(5, this.abwr.computeSize());
        this.abwr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YFk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YFk);
      }
      i = paramInt;
      if (this.abws != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abws);
      }
      paramInt = i;
      if (this.abwt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abwt);
      }
      i = paramInt;
      if (this.abwr != null) {
        i = paramInt + i.a.a.a.qC(5, this.abwr.computeSize());
      }
      AppMethodBeat.o(181510);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        etb localetb = (etb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181510);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localetb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(181510);
          return 0;
        case 2: 
          localetb.YFk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(181510);
          return 0;
        case 3: 
          localetb.abws = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(181510);
          return 0;
        case 4: 
          localetb.abwt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(181510);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etd)localObject2).parseFrom((byte[])localObject1);
          }
          localetb.abwr = ((etd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(181510);
        return 0;
      }
      AppMethodBeat.o(181510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etb
 * JD-Core Version:    0.7.0.1
 */