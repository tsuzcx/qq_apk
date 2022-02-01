package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class yk
  extends erp
{
  public String Oki;
  public String ZgT;
  public String ZgZ;
  public String Zha;
  public int Zhb;
  public String Zhc;
  public String Zhd;
  public String Zhe;
  public String Zhf;
  public int Zhg;
  public int amount;
  public int channel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZgZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZgZ != null) {
        paramVarArgs.g(2, this.ZgZ);
      }
      paramVarArgs.bS(3, this.amount);
      if (this.Zha != null) {
        paramVarArgs.g(4, this.Zha);
      }
      if (this.Oki != null) {
        paramVarArgs.g(5, this.Oki);
      }
      paramVarArgs.bS(6, this.Zhb);
      paramVarArgs.bS(7, this.channel);
      if (this.Zhc != null) {
        paramVarArgs.g(8, this.Zhc);
      }
      if (this.ZgT != null) {
        paramVarArgs.g(9, this.ZgT);
      }
      if (this.Zhd != null) {
        paramVarArgs.g(10, this.Zhd);
      }
      if (this.Zhe != null) {
        paramVarArgs.g(11, this.Zhe);
      }
      if (this.Zhf != null) {
        paramVarArgs.g(12, this.Zhf);
      }
      paramVarArgs.bS(13, this.Zhg);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1004;
      }
    }
    label1004:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZgZ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZgZ);
      }
      i += i.a.a.b.b.a.cJ(3, this.amount);
      paramInt = i;
      if (this.Zha != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zha);
      }
      i = paramInt;
      if (this.Oki != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Oki);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.Zhb) + i.a.a.b.b.a.cJ(7, this.channel);
      paramInt = i;
      if (this.Zhc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zhc);
      }
      i = paramInt;
      if (this.ZgT != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZgT);
      }
      paramInt = i;
      if (this.Zhd != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Zhd);
      }
      i = paramInt;
      if (this.Zhe != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Zhe);
      }
      paramInt = i;
      if (this.Zhf != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Zhf);
      }
      i = i.a.a.b.b.a.cJ(13, this.Zhg);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZgZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(72437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yk localyk = (yk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
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
            localyk.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localyk.ZgZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localyk.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localyk.Zha = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localyk.Oki = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localyk.Zhb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localyk.channel = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localyk.Zhc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localyk.ZgT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localyk.Zhd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localyk.Zhe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localyk.Zhf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localyk.Zhg = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yk
 * JD-Core Version:    0.7.0.1
 */