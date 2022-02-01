package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ip
  extends erp
{
  public int IKW;
  public String Jmq;
  public String YJV;
  public String YJY;
  public int YJZ;
  public gol YKb;
  public gol YKz;
  public String pSi;
  public String vgW;
  public String ytr;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IKW);
      if (this.YKz != null)
      {
        paramVarArgs.qD(3, this.YKz.computeSize());
        this.YKz.writeFields(paramVarArgs);
      }
      if (this.Jmq != null) {
        paramVarArgs.g(4, this.Jmq);
      }
      if (this.YJV != null) {
        paramVarArgs.g(5, this.YJV);
      }
      if (this.pSi != null) {
        paramVarArgs.g(6, this.pSi);
      }
      if (this.vgW != null) {
        paramVarArgs.g(7, this.vgW);
      }
      if (this.YJY != null) {
        paramVarArgs.g(8, this.YJY);
      }
      if (this.yts != null) {
        paramVarArgs.g(9, this.yts);
      }
      if (this.ytr != null) {
        paramVarArgs.g(10, this.ytr);
      }
      paramVarArgs.bS(11, this.YJZ);
      if (this.YKb != null)
      {
        paramVarArgs.qD(12, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1120;
      }
    }
    label1120:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IKW);
      paramInt = i;
      if (this.YKz != null) {
        paramInt = i + i.a.a.a.qC(3, this.YKz.computeSize());
      }
      i = paramInt;
      if (this.Jmq != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Jmq);
      }
      paramInt = i;
      if (this.YJV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YJV);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.pSi);
      }
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.vgW);
      }
      i = paramInt;
      if (this.YJY != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YJY);
      }
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.yts);
      }
      i = paramInt;
      if (this.ytr != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ytr);
      }
      i += i.a.a.b.b.a.cJ(11, this.YJZ);
      paramInt = i;
      if (this.YKb != null) {
        paramInt = i + i.a.a.a.qC(12, this.YKb.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YKz == null)
        {
          paramVarArgs = new b("Not all required fields were included: AxTicket");
          AppMethodBeat.o(133150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133150);
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
            localip.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localip.IKW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
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
            localip.YKz = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localip.Jmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localip.YJV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localip.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localip.vgW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localip.YJY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localip.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localip.ytr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localip.YJZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133150);
          return 0;
        }
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
          localip.YKb = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      AppMethodBeat.o(133150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */