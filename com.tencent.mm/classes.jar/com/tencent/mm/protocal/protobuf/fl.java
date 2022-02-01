package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fl
  extends dop
{
  public int KIJ;
  public int KIK;
  public int KIL;
  public long KIM;
  public int offset;
  public int pTI;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103189);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.aM(4, this.offset);
      paramVarArgs.aM(6, this.pTI);
      paramVarArgs.aM(7, this.scene);
      paramVarArgs.aM(8, this.KIL);
      paramVarArgs.aM(9, this.KIK);
      paramVarArgs.aM(10, this.KIJ);
      if (this.session_id != null) {
        paramVarArgs.e(11, this.session_id);
      }
      paramVarArgs.bb(12, this.KIM);
      AppMethodBeat.o(103189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.url);
      }
      i = i + g.a.a.b.b.a.bu(4, this.offset) + g.a.a.b.b.a.bu(6, this.pTI) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.KIL) + g.a.a.b.b.a.bu(9, this.KIK) + g.a.a.b.b.a.bu(10, this.KIJ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.session_id);
      }
      i = g.a.a.b.b.a.r(12, this.KIM);
      AppMethodBeat.o(103189);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fl localfl = (fl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(103189);
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
            localfl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103189);
          return 0;
        case 2: 
          localfl.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103189);
          return 0;
        case 4: 
          localfl.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103189);
          return 0;
        case 6: 
          localfl.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103189);
          return 0;
        case 7: 
          localfl.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103189);
          return 0;
        case 8: 
          localfl.KIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103189);
          return 0;
        case 9: 
          localfl.KIK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103189);
          return 0;
        case 10: 
          localfl.KIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103189);
          return 0;
        case 11: 
          localfl.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103189);
          return 0;
        }
        localfl.KIM = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(103189);
        return 0;
      }
      AppMethodBeat.o(103189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fl
 * JD-Core Version:    0.7.0.1
 */