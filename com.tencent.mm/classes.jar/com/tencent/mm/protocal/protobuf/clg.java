package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clg
  extends erp
{
  public int aatk;
  public int aatl;
  public String aatm;
  public boolean aatn;
  public enu aato;
  public boolean aatp;
  public LinkedList<dby> aatq;
  public LinkedList<ade> aatr;
  
  public clg()
  {
    AppMethodBeat.i(257937);
    this.aatq = new LinkedList();
    this.aatr = new LinkedList();
    AppMethodBeat.o(257937);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257944);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aatk);
      paramVarArgs.bS(3, this.aatl);
      if (this.aatm != null) {
        paramVarArgs.g(4, this.aatm);
      }
      paramVarArgs.di(5, this.aatn);
      if (this.aato != null)
      {
        paramVarArgs.qD(6, this.aato.computeSize());
        this.aato.writeFields(paramVarArgs);
      }
      paramVarArgs.di(7, this.aatp);
      paramVarArgs.e(8, 8, this.aatq);
      paramVarArgs.e(9, 8, this.aatr);
      AppMethodBeat.o(257944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aatk) + i.a.a.b.b.a.cJ(3, this.aatl);
      paramInt = i;
      if (this.aatm != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aatm);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.aato != null) {
        paramInt = i + i.a.a.a.qC(6, this.aato.computeSize());
      }
      i = i.a.a.b.b.a.ko(7);
      int j = i.a.a.a.c(8, 8, this.aatq);
      int k = i.a.a.a.c(9, 8, this.aatr);
      AppMethodBeat.o(257944);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aatq.clear();
        this.aatr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257944);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clg localclg = (clg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257944);
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
            localclg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257944);
          return 0;
        case 2: 
          localclg.aatk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257944);
          return 0;
        case 3: 
          localclg.aatl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257944);
          return 0;
        case 4: 
          localclg.aatm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257944);
          return 0;
        case 5: 
          localclg.aatn = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257944);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enu)localObject2).parseFrom((byte[])localObject1);
            }
            localclg.aato = ((enu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257944);
          return 0;
        case 7: 
          localclg.aatp = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257944);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dby();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dby)localObject2).parseFrom((byte[])localObject1);
            }
            localclg.aatq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257944);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ade();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ade)localObject2).parseFrom((byte[])localObject1);
          }
          localclg.aatr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257944);
        return 0;
      }
      AppMethodBeat.o(257944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clg
 * JD-Core Version:    0.7.0.1
 */