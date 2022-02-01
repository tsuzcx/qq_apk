package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class baw
  extends esc
{
  public b AEn;
  public String ZEb;
  public bku ZKN;
  public LinkedList<bwa> ZLJ;
  public LinkedList<bwm> ZLK;
  public bwe ZLL;
  public atx ZLM;
  public int continueFlag;
  public b lastBuffer;
  public LinkedList<FinderObject> object;
  public btc preloadInfo;
  
  public baw()
  {
    AppMethodBeat.i(259843);
    this.object = new LinkedList();
    this.ZLJ = new LinkedList();
    this.ZLK = new LinkedList();
    AppMethodBeat.o(259843);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259853);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      if (this.AEn != null) {
        paramVarArgs.d(5, this.AEn);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.qD(6, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.ZEb != null) {
        paramVarArgs.g(7, this.ZEb);
      }
      paramVarArgs.e(8, 8, this.ZLJ);
      paramVarArgs.e(9, 8, this.ZLK);
      if (this.ZKN != null)
      {
        paramVarArgs.qD(10, this.ZKN.computeSize());
        this.ZKN.writeFields(paramVarArgs);
      }
      if (this.ZLL != null)
      {
        paramVarArgs.qD(11, this.ZLL.computeSize());
        this.ZLL.writeFields(paramVarArgs);
      }
      if (this.ZLM != null)
      {
        paramVarArgs.qD(12, this.ZLM.computeSize());
        this.ZLM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259853);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1402;
      }
    }
    label1402:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.continueFlag);
      paramInt = i;
      if (this.AEn != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.AEn);
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + i.a.a.a.qC(6, this.preloadInfo.computeSize());
      }
      paramInt = i;
      if (this.ZEb != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZEb);
      }
      i = paramInt + i.a.a.a.c(8, 8, this.ZLJ) + i.a.a.a.c(9, 8, this.ZLK);
      paramInt = i;
      if (this.ZKN != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZKN.computeSize());
      }
      i = paramInt;
      if (this.ZLL != null) {
        i = paramInt + i.a.a.a.qC(11, this.ZLL.computeSize());
      }
      paramInt = i;
      if (this.ZLM != null) {
        paramInt = i + i.a.a.a.qC(12, this.ZLM.computeSize());
      }
      AppMethodBeat.o(259853);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.ZLJ.clear();
        this.ZLK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259853);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        baw localbaw = (baw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259853);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        case 3: 
          localbaw.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259853);
          return 0;
        case 4: 
          localbaw.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259853);
          return 0;
        case 5: 
          localbaw.AEn = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259853);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btc)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.preloadInfo = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        case 7: 
          localbaw.ZEb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259853);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwa)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.ZLJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwm)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.ZLK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.ZKN = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bwe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bwe)localObject2).parseFrom((byte[])localObject1);
            }
            localbaw.ZLL = ((bwe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259853);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new atx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((atx)localObject2).parseFrom((byte[])localObject1);
          }
          localbaw.ZLM = ((atx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259853);
        return 0;
      }
      AppMethodBeat.o(259853);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baw
 * JD-Core Version:    0.7.0.1
 */