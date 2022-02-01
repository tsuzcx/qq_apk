package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aml
  extends erp
{
  public String YJX;
  public int YKH;
  public String YNN;
  public gol YOj;
  public String YOy;
  public String Ztu;
  public String Ztv;
  public int Ztw;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155402);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155402);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(2, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YKH);
      if (this.YNN != null) {
        paramVarArgs.g(4, this.YNN);
      }
      if (this.yts != null) {
        paramVarArgs.g(5, this.yts);
      }
      if (this.YOy != null) {
        paramVarArgs.g(6, this.YOy);
      }
      if (this.Ztu != null) {
        paramVarArgs.g(7, this.Ztu);
      }
      if (this.YJX != null) {
        paramVarArgs.g(8, this.YJX);
      }
      if (this.Ztv != null) {
        paramVarArgs.g(9, this.Ztv);
      }
      paramVarArgs.bS(10, this.Ztw);
      AppMethodBeat.o(155402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YOj != null) {
        i = paramInt + i.a.a.a.qC(2, this.YOj.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.YKH);
      paramInt = i;
      if (this.YNN != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNN);
      }
      i = paramInt;
      if (this.yts != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.yts);
      }
      paramInt = i;
      if (this.YOy != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YOy);
      }
      i = paramInt;
      if (this.Ztu != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Ztu);
      }
      paramInt = i;
      if (this.YJX != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YJX);
      }
      i = paramInt;
      if (this.Ztv != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Ztv);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.Ztw);
      AppMethodBeat.o(155402);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aml localaml = (aml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155402);
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
            localaml.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localaml.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 3: 
          localaml.YKH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155402);
          return 0;
        case 4: 
          localaml.YNN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 5: 
          localaml.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 6: 
          localaml.YOy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 7: 
          localaml.Ztu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 8: 
          localaml.YJX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 9: 
          localaml.Ztv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155402);
          return 0;
        }
        localaml.Ztw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(155402);
        return 0;
      }
      AppMethodBeat.o(155402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aml
 * JD-Core Version:    0.7.0.1
 */