package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sh
  extends erp
{
  public int OhP;
  public String OhQ;
  public String OhR;
  public String Oiu;
  public String Oiv;
  public String Oiw;
  public int Oix;
  public LinkedList<apu> Oiy;
  public int YXk;
  public int amount;
  public int channel;
  public String nQU;
  
  public sh()
  {
    AppMethodBeat.i(259809);
    this.Oiy = new LinkedList();
    AppMethodBeat.o(259809);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.amount);
      paramVarArgs.bS(3, this.channel);
      paramVarArgs.bS(4, this.OhP);
      if (this.Oiu != null) {
        paramVarArgs.g(5, this.Oiu);
      }
      if (this.Oiv != null) {
        paramVarArgs.g(6, this.Oiv);
      }
      if (this.OhQ != null) {
        paramVarArgs.g(7, this.OhQ);
      }
      if (this.Oiw != null) {
        paramVarArgs.g(8, this.Oiw);
      }
      if (this.nQU != null) {
        paramVarArgs.g(9, this.nQU);
      }
      if (this.OhR != null) {
        paramVarArgs.g(10, this.OhR);
      }
      paramVarArgs.bS(11, this.Oix);
      paramVarArgs.bS(12, this.YXk);
      paramVarArgs.e(13, 8, this.Oiy);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1002;
      }
    }
    label1002:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.amount) + i.a.a.b.b.a.cJ(3, this.channel) + i.a.a.b.b.a.cJ(4, this.OhP);
      paramInt = i;
      if (this.Oiu != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Oiu);
      }
      i = paramInt;
      if (this.Oiv != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Oiv);
      }
      paramInt = i;
      if (this.OhQ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.OhQ);
      }
      i = paramInt;
      if (this.Oiw != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Oiw);
      }
      paramInt = i;
      if (this.nQU != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.nQU);
      }
      i = paramInt;
      if (this.OhR != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.OhR);
      }
      paramInt = i.a.a.b.b.a.cJ(11, this.Oix);
      int j = i.a.a.b.b.a.cJ(12, this.YXk);
      int k = i.a.a.a.c(13, 8, this.Oiy);
      AppMethodBeat.o(91370);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Oiy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sh localsh = (sh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
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
            localsh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localsh.amount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localsh.channel = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localsh.OhP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localsh.Oiu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localsh.Oiv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localsh.OhQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localsh.Oiw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localsh.nQU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localsh.OhR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 11: 
          localsh.Oix = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91370);
          return 0;
        case 12: 
          localsh.YXk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91370);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new apu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((apu)localObject2).parseFrom((byte[])localObject1);
          }
          localsh.Oiy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sh
 * JD-Core Version:    0.7.0.1
 */