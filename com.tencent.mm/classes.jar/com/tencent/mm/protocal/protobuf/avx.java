package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avx
  extends dyl
{
  public aqo SCW;
  public b SDI;
  public aqe SFL;
  public etb SIm;
  public b SIn;
  public int fEH;
  public int fromType;
  public float latitude;
  public float longitude;
  public String topic;
  public int wXA;
  public long wZw;
  public String xEG;
  public int xEw;
  public biv xcZ;
  public long xee;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SFL != null)
      {
        paramVarArgs.oE(2, this.SFL.computeSize());
        this.SFL.writeFields(paramVarArgs);
      }
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.aY(4, this.wXA);
      if (this.topic != null) {
        paramVarArgs.f(5, this.topic);
      }
      paramVarArgs.i(6, this.longitude);
      paramVarArgs.i(7, this.latitude);
      paramVarArgs.bm(8, this.wZw);
      paramVarArgs.aY(9, this.fEH);
      if (this.SIm != null)
      {
        paramVarArgs.oE(10, this.SIm.computeSize());
        this.SIm.writeFields(paramVarArgs);
      }
      if (this.xcZ != null)
      {
        paramVarArgs.oE(11, this.xcZ.computeSize());
        this.xcZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.fromType);
      if (this.SCW != null)
      {
        paramVarArgs.oE(13, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(14, this.xee);
      if (this.SIn != null) {
        paramVarArgs.c(15, this.SIn);
      }
      if (this.xEG != null) {
        paramVarArgs.f(16, this.xEG);
      }
      paramVarArgs.aY(17, this.xEw);
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1430;
      }
    }
    label1430:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SFL != null) {
        paramInt = i + g.a.a.a.oD(2, this.SFL.computeSize());
      }
      i = paramInt;
      if (this.SDI != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SDI);
      }
      i += g.a.a.b.b.a.bM(4, this.wXA);
      paramInt = i;
      if (this.topic != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.topic);
      }
      i = paramInt + (g.a.a.b.b.a.gL(6) + 4) + (g.a.a.b.b.a.gL(7) + 4) + g.a.a.b.b.a.p(8, this.wZw) + g.a.a.b.b.a.bM(9, this.fEH);
      paramInt = i;
      if (this.SIm != null) {
        paramInt = i + g.a.a.a.oD(10, this.SIm.computeSize());
      }
      i = paramInt;
      if (this.xcZ != null) {
        i = paramInt + g.a.a.a.oD(11, this.xcZ.computeSize());
      }
      i += g.a.a.b.b.a.bM(12, this.fromType);
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(13, this.SCW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(14, this.xee);
      paramInt = i;
      if (this.SIn != null) {
        paramInt = i + g.a.a.b.b.a.b(15, this.SIn);
      }
      i = paramInt;
      if (this.xEG != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.xEG);
      }
      paramInt = g.a.a.b.b.a.bM(17, this.xEw);
      AppMethodBeat.o(168990);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avx localavx = (avx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localavx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localavx.SFL = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localavx.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localavx.wXA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localavx.topic = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localavx.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localavx.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localavx.wZw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localavx.fEH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etb)localObject2).parseFrom((byte[])localObject1);
            }
            localavx.SIm = ((etb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new biv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((biv)localObject2).parseFrom((byte[])localObject1);
            }
            localavx.xcZ = ((biv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 12: 
          localavx.fromType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168990);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localavx.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 14: 
          localavx.xee = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168990);
          return 0;
        case 15: 
          localavx.SIn = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168990);
          return 0;
        case 16: 
          localavx.xEG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168990);
          return 0;
        }
        localavx.xEw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avx
 * JD-Core Version:    0.7.0.1
 */