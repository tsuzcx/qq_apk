package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebg
  extends dop
{
  public int BsF;
  public int BsG;
  public int ExtFlag;
  public String KHk;
  public SKBuiltinBuffer_t KMS;
  public int Llx;
  public String MD5;
  public ekv MID;
  public int MsU;
  public int MsV;
  public int NaX;
  public int NaY;
  public int NaZ;
  public String izX;
  public String jfi;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.BsG);
      paramVarArgs.aM(17, this.NaX);
      paramVarArgs.aM(4, this.BsF);
      if (this.KMS != null)
      {
        paramVarArgs.ni(5, this.KMS.computeSize());
        this.KMS.writeFields(paramVarArgs);
      }
      if (this.izX != null) {
        paramVarArgs.e(6, this.izX);
      }
      paramVarArgs.aM(7, this.MsU);
      paramVarArgs.aM(8, this.MsV);
      if (this.KHk != null) {
        paramVarArgs.e(9, this.KHk);
      }
      paramVarArgs.aM(10, this.NaY);
      paramVarArgs.aM(11, this.Llx);
      if (this.MID != null)
      {
        paramVarArgs.ni(12, this.MID.computeSize());
        this.MID.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(13, this.jfi);
      }
      paramVarArgs.aM(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.e(15, this.MD5);
      }
      paramVarArgs.aM(16, this.NaZ);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.BsG) + g.a.a.b.b.a.bu(17, this.NaX) + g.a.a.b.b.a.bu(4, this.BsF);
      paramInt = i;
      if (this.KMS != null) {
        paramInt = i + g.a.a.a.nh(5, this.KMS.computeSize());
      }
      i = paramInt;
      if (this.izX != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.izX);
      }
      i = i + g.a.a.b.b.a.bu(7, this.MsU) + g.a.a.b.b.a.bu(8, this.MsV);
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KHk);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.NaY) + g.a.a.b.b.a.bu(11, this.Llx);
      paramInt = i;
      if (this.MID != null) {
        paramInt = i + g.a.a.a.nh(12, this.MID.computeSize());
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.jfi);
      }
      i += g.a.a.b.b.a.bu(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.MD5);
      }
      i = g.a.a.b.b.a.bu(16, this.NaZ);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KMS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebg localebg = (ebg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebg.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localebg.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localebg.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localebg.NaX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localebg.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebg.KMS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localebg.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localebg.MsU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localebg.MsV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localebg.KHk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localebg.NaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localebg.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebg.MID = ((ekv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localebg.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localebg.ExtFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localebg.MD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localebg.NaZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebg
 * JD-Core Version:    0.7.0.1
 */