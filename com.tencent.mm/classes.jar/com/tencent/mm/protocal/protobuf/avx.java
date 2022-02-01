package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class avx
  extends dop
{
  public aov LAI;
  public b LFp;
  public long LGk;
  public String LGs;
  public String finderUsername;
  public long hFK;
  public b lastBuffer;
  public long liveId;
  public int scene;
  public String tWb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209517);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      paramVarArgs.bb(4, this.liveId);
      paramVarArgs.bb(5, this.hFK);
      paramVarArgs.bb(6, this.LGk);
      if (this.tWb != null) {
        paramVarArgs.e(7, this.tWb);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      if (this.LGs != null) {
        paramVarArgs.e(9, this.LGs);
      }
      if (this.LFp != null) {
        paramVarArgs.c(10, this.LFp);
      }
      paramVarArgs.aM(11, this.scene);
      AppMethodBeat.o(209517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      i = i + g.a.a.b.b.a.r(4, this.liveId) + g.a.a.b.b.a.r(5, this.hFK) + g.a.a.b.b.a.r(6, this.LGk);
      paramInt = i;
      if (this.tWb != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.tWb);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.lastBuffer);
      }
      paramInt = i;
      if (this.LGs != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LGs);
      }
      i = paramInt;
      if (this.LFp != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.LFp);
      }
      paramInt = g.a.a.b.b.a.bu(11, this.scene);
      AppMethodBeat.o(209517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avx localavx = (avx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209517);
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
            localavx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209517);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavx.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209517);
          return 0;
        case 3: 
          localavx.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209517);
          return 0;
        case 4: 
          localavx.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209517);
          return 0;
        case 5: 
          localavx.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209517);
          return 0;
        case 6: 
          localavx.LGk = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209517);
          return 0;
        case 7: 
          localavx.tWb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209517);
          return 0;
        case 8: 
          localavx.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209517);
          return 0;
        case 9: 
          localavx.LGs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209517);
          return 0;
        case 10: 
          localavx.LFp = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209517);
          return 0;
        }
        localavx.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209517);
        return 0;
      }
      AppMethodBeat.o(209517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avx
 * JD-Core Version:    0.7.0.1
 */