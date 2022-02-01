package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fd
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String KHq;
  public SKBuiltinBuffer_t KIA;
  public int KIB;
  public String KIC;
  public String KID;
  public String KIE;
  public int KIF;
  public int KIy;
  public String KIz;
  public String iAc;
  public String jfi;
  public int oUv;
  public String xNG;
  public String xNH;
  public int xub;
  public String xuk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xNH != null) {
        paramVarArgs.e(1, this.xNH);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      paramVarArgs.aM(3, this.KIy);
      if (this.xNG != null) {
        paramVarArgs.e(4, this.xNG);
      }
      paramVarArgs.aM(5, this.oUv);
      if (this.iAc != null) {
        paramVarArgs.e(6, this.iAc);
      }
      paramVarArgs.aM(7, this.CreateTime);
      if (this.KIz != null) {
        paramVarArgs.e(8, this.KIz);
      }
      if (this.KIA != null)
      {
        paramVarArgs.ni(9, this.KIA.computeSize());
        this.KIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.xub);
      paramVarArgs.aM(11, this.KIB);
      if (this.KHq != null) {
        paramVarArgs.e(12, this.KHq);
      }
      if (this.KIC != null) {
        paramVarArgs.e(13, this.KIC);
      }
      if (this.KID != null) {
        paramVarArgs.e(14, this.KID);
      }
      if (this.KIE != null) {
        paramVarArgs.e(15, this.KIE);
      }
      paramVarArgs.aM(16, this.KIF);
      if (this.xuk != null) {
        paramVarArgs.e(17, this.xuk);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNH == null) {
        break label1221;
      }
    }
    label1221:
    for (paramInt = g.a.a.b.b.a.f(1, this.xNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.jfi);
      }
      i += g.a.a.b.b.a.bu(3, this.KIy);
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNG);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.oUv);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.iAc);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.CreateTime);
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KIz);
      }
      i = paramInt;
      if (this.KIA != null) {
        i = paramInt + g.a.a.a.nh(9, this.KIA.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(10, this.xub) + g.a.a.b.b.a.bu(11, this.KIB);
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KHq);
      }
      i = paramInt;
      if (this.KIC != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KIC);
      }
      paramInt = i;
      if (this.KID != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.KID);
      }
      i = paramInt;
      if (this.KIE != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.KIE);
      }
      i += g.a.a.b.b.a.bu(16, this.KIF);
      paramInt = i;
      if (this.xuk != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.xuk);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fd localfd = (fd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localfd.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localfd.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localfd.KIy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localfd.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localfd.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localfd.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localfd.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localfd.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfd.KIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localfd.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localfd.KIB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localfd.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localfd.KIC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localfd.KID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localfd.KIE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localfd.KIF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32116);
          return 0;
        }
        localfd.xuk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fd
 * JD-Core Version:    0.7.0.1
 */