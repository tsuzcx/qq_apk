package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bck
  extends esc
{
  public int BeA;
  public b ZEQ;
  public b ZIF;
  public bku ZKN;
  public int ZKX;
  public bwe ZLL;
  public bch ZNv;
  public boolean akhs;
  public LinkedList<FinderObject> object;
  public int wrl;
  
  public bck()
  {
    AppMethodBeat.i(259393);
    this.object = new LinkedList();
    AppMethodBeat.o(259393);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259400);
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
      if (this.ZKN != null)
      {
        paramVarArgs.qD(5, this.ZKN.computeSize());
        this.ZKN.writeFields(paramVarArgs);
      }
      if (this.ZLL != null)
      {
        paramVarArgs.qD(6, this.ZLL.computeSize());
        this.ZLL.writeFields(paramVarArgs);
      }
      if (this.ZNv != null)
      {
        paramVarArgs.qD(7, this.ZNv.computeSize());
        this.ZNv.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZKX);
      if (this.ZIF != null) {
        paramVarArgs.d(9, this.ZIF);
      }
      paramVarArgs.bS(10, this.wrl);
      paramVarArgs.di(11, this.akhs);
      AppMethodBeat.o(259400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1108;
      }
    }
    label1108:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.BeA);
      paramInt = i;
      if (this.ZKN != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZKN.computeSize());
      }
      i = paramInt;
      if (this.ZLL != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZLL.computeSize());
      }
      paramInt = i;
      if (this.ZNv != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZNv.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.ZKX);
      paramInt = i;
      if (this.ZIF != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.ZIF);
      }
      i = i.a.a.b.b.a.cJ(10, this.wrl);
      int j = i.a.a.b.b.a.ko(11);
      AppMethodBeat.o(259400);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bck localbck = (bck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259400);
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
            localbck.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259400);
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
            localbck.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259400);
          return 0;
        case 3: 
          localbck.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259400);
          return 0;
        case 4: 
          localbck.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259400);
          return 0;
        case 5: 
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
            localbck.ZKN = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259400);
          return 0;
        case 6: 
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
            localbck.ZLL = ((bwe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259400);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bch();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bch)localObject2).parseFrom((byte[])localObject1);
            }
            localbck.ZNv = ((bch)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259400);
          return 0;
        case 8: 
          localbck.ZKX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259400);
          return 0;
        case 9: 
          localbck.ZIF = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259400);
          return 0;
        case 10: 
          localbck.wrl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259400);
          return 0;
        }
        localbck.akhs = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(259400);
        return 0;
      }
      AppMethodBeat.o(259400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bck
 * JD-Core Version:    0.7.0.1
 */