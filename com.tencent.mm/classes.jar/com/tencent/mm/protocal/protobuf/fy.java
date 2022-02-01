package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fy
  extends dop
{
  public int KIJ;
  public int KIK;
  public int KIL;
  public long KIM;
  public int KJJ;
  public int KJL;
  public long KJO;
  public String content;
  public int pTI;
  public int scene;
  public String session_id;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103199);
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
      if (this.content != null) {
        paramVarArgs.e(4, this.content);
      }
      paramVarArgs.bb(5, this.KJO);
      paramVarArgs.aM(6, this.pTI);
      paramVarArgs.aM(7, this.KJJ);
      if (this.title != null) {
        paramVarArgs.e(8, this.title);
      }
      paramVarArgs.aM(9, this.scene);
      paramVarArgs.aM(10, this.KIL);
      paramVarArgs.aM(11, this.KIK);
      paramVarArgs.aM(12, this.KIJ);
      if (this.session_id != null) {
        paramVarArgs.e(13, this.session_id);
      }
      paramVarArgs.bb(14, this.KIM);
      paramVarArgs.aM(15, this.KJL);
      AppMethodBeat.o(103199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.content);
      }
      i = i + g.a.a.b.b.a.r(5, this.KJO) + g.a.a.b.b.a.bu(6, this.pTI) + g.a.a.b.b.a.bu(7, this.KJJ);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.title);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.scene) + g.a.a.b.b.a.bu(10, this.KIL) + g.a.a.b.b.a.bu(11, this.KIK) + g.a.a.b.b.a.bu(12, this.KIJ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.session_id);
      }
      i = g.a.a.b.b.a.r(14, this.KIM);
      int j = g.a.a.b.b.a.bu(15, this.KJL);
      AppMethodBeat.o(103199);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fy localfy = (fy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103199);
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
            localfy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103199);
          return 0;
        case 2: 
          localfy.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 4: 
          localfy.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 5: 
          localfy.KJO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(103199);
          return 0;
        case 6: 
          localfy.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103199);
          return 0;
        case 7: 
          localfy.KJJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103199);
          return 0;
        case 8: 
          localfy.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 9: 
          localfy.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103199);
          return 0;
        case 10: 
          localfy.KIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103199);
          return 0;
        case 11: 
          localfy.KIK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103199);
          return 0;
        case 12: 
          localfy.KIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103199);
          return 0;
        case 13: 
          localfy.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 14: 
          localfy.KIM = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(103199);
          return 0;
        }
        localfy.KJL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103199);
        return 0;
      }
      AppMethodBeat.o(103199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fy
 * JD-Core Version:    0.7.0.1
 */