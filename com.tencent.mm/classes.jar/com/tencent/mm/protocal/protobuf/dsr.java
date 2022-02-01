package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dsr
  extends esc
{
  public int BeA;
  public btc ZDZ;
  public b ZEQ;
  public b ZFz;
  public bku ZKN;
  public LinkedList<bwa> ZLJ;
  public LinkedList<bwm> ZLK;
  public bwe ZLL;
  public String aaYo;
  public LinkedList<FinderObject> object;
  public String request_id;
  
  public dsr()
  {
    AppMethodBeat.i(259628);
    this.object = new LinkedList();
    this.ZLJ = new LinkedList();
    this.ZLK = new LinkedList();
    AppMethodBeat.o(259628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259636);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.BeA);
      if (this.ZFz != null) {
        paramVarArgs.d(5, this.ZFz);
      }
      if (this.ZDZ != null)
      {
        paramVarArgs.qD(6, this.ZDZ.computeSize());
        this.ZDZ.writeFields(paramVarArgs);
      }
      if (this.aaYo != null) {
        paramVarArgs.g(7, this.aaYo);
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
      if (this.request_id != null) {
        paramVarArgs.g(100, this.request_id);
      }
      AppMethodBeat.o(259636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1376;
      }
    }
    label1376:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.BeA);
      paramInt = i;
      if (this.ZFz != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZFz);
      }
      i = paramInt;
      if (this.ZDZ != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZDZ.computeSize());
      }
      paramInt = i;
      if (this.aaYo != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaYo);
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
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.request_id);
      }
      AppMethodBeat.o(259636);
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
        AppMethodBeat.o(259636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dsr localdsr = (dsr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259636);
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
            localdsr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
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
            localdsr.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
          return 0;
        case 3: 
          localdsr.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259636);
          return 0;
        case 4: 
          localdsr.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259636);
          return 0;
        case 5: 
          localdsr.ZFz = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259636);
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
            localdsr.ZDZ = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
          return 0;
        case 7: 
          localdsr.aaYo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259636);
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
            localdsr.ZLJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
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
            localdsr.ZLK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
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
            localdsr.ZKN = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
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
            localdsr.ZLL = ((bwe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259636);
          return 0;
        }
        localdsr.request_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259636);
        return 0;
      }
      AppMethodBeat.o(259636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsr
 * JD-Core Version:    0.7.0.1
 */