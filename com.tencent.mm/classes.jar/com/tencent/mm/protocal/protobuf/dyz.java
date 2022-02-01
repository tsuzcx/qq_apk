package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dyz
  extends ckq
{
  public aht DlF;
  public int IoU;
  public dzq KJJ;
  public b KKa;
  public String Lxw;
  public String Lxx;
  public dye Lxy;
  public float dpb;
  public float dqQ;
  public b lastBuffer;
  public long objectId;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DlF != null)
      {
        paramVarArgs.kX(2, this.DlF.computeSize());
        this.DlF.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aG(4, this.objectId);
      paramVarArgs.aR(5, this.IoU);
      paramVarArgs.x(6, this.dqQ);
      paramVarArgs.x(7, this.dpb);
      if (this.objectNonceId != null) {
        paramVarArgs.d(8, this.objectNonceId);
      }
      if (this.Lxw != null) {
        paramVarArgs.d(9, this.Lxw);
      }
      paramVarArgs.aR(10, this.scene);
      if (this.Lxx != null) {
        paramVarArgs.d(11, this.Lxx);
      }
      if (this.KJJ != null)
      {
        paramVarArgs.kX(12, this.KJJ.computeSize());
        this.KJJ.writeFields(paramVarArgs);
      }
      if (this.Lxy != null)
      {
        paramVarArgs.kX(13, this.Lxy.computeSize());
        this.Lxy.writeFields(paramVarArgs);
      }
      if (this.KKa != null) {
        paramVarArgs.c(14, this.KKa);
      }
      AppMethodBeat.o(203854);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1308;
      }
    }
    label1308:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DlF != null) {
        paramInt = i + f.a.a.a.kW(2, this.DlF.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + f.a.a.b.b.a.q(4, this.objectId) + f.a.a.b.b.a.bA(5, this.IoU) + (f.a.a.b.b.a.fY(6) + 4) + (f.a.a.b.b.a.fY(7) + 4);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.Lxw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Lxw);
      }
      i += f.a.a.b.b.a.bA(10, this.scene);
      paramInt = i;
      if (this.Lxx != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Lxx);
      }
      i = paramInt;
      if (this.KJJ != null) {
        i = paramInt + f.a.a.a.kW(12, this.KJJ.computeSize());
      }
      paramInt = i;
      if (this.Lxy != null) {
        paramInt = i + f.a.a.a.kW(13, this.Lxy.computeSize());
      }
      i = paramInt;
      if (this.KKa != null) {
        i = paramInt + f.a.a.b.b.a.b(14, this.KKa);
      }
      AppMethodBeat.o(203854);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203854);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyz localdyz = (dyz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203854);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203854);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyz.DlF = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203854);
          return 0;
        case 3: 
          localdyz.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(203854);
          return 0;
        case 4: 
          localdyz.objectId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(203854);
          return 0;
        case 5: 
          localdyz.IoU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203854);
          return 0;
        case 6: 
          localdyz.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(203854);
          return 0;
        case 7: 
          localdyz.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(203854);
          return 0;
        case 8: 
          localdyz.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203854);
          return 0;
        case 9: 
          localdyz.Lxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203854);
          return 0;
        case 10: 
          localdyz.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(203854);
          return 0;
        case 11: 
          localdyz.Lxx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(203854);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyz.KJJ = ((dzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203854);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dye();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dye)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyz.Lxy = ((dye)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203854);
          return 0;
        }
        localdyz.KKa = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(203854);
        return 0;
      }
      AppMethodBeat.o(203854);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyz
 * JD-Core Version:    0.7.0.1
 */