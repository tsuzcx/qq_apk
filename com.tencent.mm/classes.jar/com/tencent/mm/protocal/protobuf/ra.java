package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ra
  extends erp
{
  public int MzP;
  public String OQV;
  public int count;
  public String mut;
  public String muu;
  public String muv;
  public String muw;
  public String mux;
  public int muy;
  public String muz;
  public String productid;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124452);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mut != null) {
        paramVarArgs.g(2, this.mut);
      }
      if (this.muu != null) {
        paramVarArgs.g(3, this.muu);
      }
      if (this.muv != null) {
        paramVarArgs.g(4, this.muv);
      }
      if (this.muw != null) {
        paramVarArgs.g(5, this.muw);
      }
      if (this.mux != null) {
        paramVarArgs.g(6, this.mux);
      }
      paramVarArgs.bS(7, this.muy);
      if (this.muz != null) {
        paramVarArgs.g(8, this.muz);
      }
      if (this.productid != null) {
        paramVarArgs.g(9, this.productid);
      }
      if (this.OQV != null) {
        paramVarArgs.g(10, this.OQV);
      }
      paramVarArgs.bS(11, this.type);
      if (this.value != null) {
        paramVarArgs.g(12, this.value);
      }
      paramVarArgs.bS(13, this.count);
      paramVarArgs.bS(14, this.MzP);
      AppMethodBeat.o(124452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1020;
      }
    }
    label1020:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mut);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.muu);
      }
      paramInt = i;
      if (this.muv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.muv);
      }
      i = paramInt;
      if (this.muw != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.muw);
      }
      paramInt = i;
      if (this.mux != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mux);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.muy);
      paramInt = i;
      if (this.muz != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.muz);
      }
      i = paramInt;
      if (this.productid != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.productid);
      }
      paramInt = i;
      if (this.OQV != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.OQV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.value);
      }
      i = i.a.a.b.b.a.cJ(13, this.count);
      int j = i.a.a.b.b.a.cJ(14, this.MzP);
      AppMethodBeat.o(124452);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ra localra = (ra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124452);
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
            localra.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124452);
          return 0;
        case 2: 
          localra.mut = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 3: 
          localra.muu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 4: 
          localra.muv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 5: 
          localra.muw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 6: 
          localra.mux = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 7: 
          localra.muy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124452);
          return 0;
        case 8: 
          localra.muz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 9: 
          localra.productid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 10: 
          localra.OQV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 11: 
          localra.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124452);
          return 0;
        case 12: 
          localra.value = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 13: 
          localra.count = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124452);
          return 0;
        }
        localra.MzP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124452);
        return 0;
      }
      AppMethodBeat.o(124452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ra
 * JD-Core Version:    0.7.0.1
 */