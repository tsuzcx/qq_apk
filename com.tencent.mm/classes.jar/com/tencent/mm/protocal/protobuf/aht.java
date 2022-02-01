package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aht
  extends dop
{
  public long Brn;
  public int BsF;
  public int BsG;
  public int BsH;
  public int KIy;
  public int LrA;
  public int LrB;
  public String Lrz;
  public String UserName;
  public String jfi;
  public String jfl;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      paramVarArgs.aM(3, this.KIy);
      if (this.jfl != null) {
        paramVarArgs.e(4, this.jfl);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      paramVarArgs.aM(6, this.BsF);
      paramVarArgs.aM(7, this.BsG);
      paramVarArgs.aM(8, this.BsH);
      if (this.Lrz != null) {
        paramVarArgs.e(9, this.Lrz);
      }
      paramVarArgs.aM(10, this.LrA);
      paramVarArgs.aM(11, this.oUv);
      paramVarArgs.aM(12, this.LrB);
      paramVarArgs.bb(13, this.Brn);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.jfi);
      }
      i += g.a.a.b.b.a.bu(3, this.KIy);
      paramInt = i;
      if (this.jfl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.jfl);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      i = i + g.a.a.b.b.a.bu(6, this.BsF) + g.a.a.b.b.a.bu(7, this.BsG) + g.a.a.b.b.a.bu(8, this.BsH);
      paramInt = i;
      if (this.Lrz != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Lrz);
      }
      i = g.a.a.b.b.a.bu(10, this.LrA);
      int j = g.a.a.b.b.a.bu(11, this.oUv);
      int k = g.a.a.b.b.a.bu(12, this.LrB);
      int m = g.a.a.b.b.a.r(13, this.Brn);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aht localaht = (aht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaht.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localaht.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localaht.KIy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localaht.jfl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localaht.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localaht.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localaht.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localaht.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localaht.Lrz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localaht.LrA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localaht.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localaht.LrB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(9590);
          return 0;
        }
        localaht.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aht
 * JD-Core Version:    0.7.0.1
 */