package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fu
  extends dop
{
  public int KIJ;
  public int KIK;
  public int KIL;
  public int KJJ;
  public int KJK;
  public int KJL;
  public String openid;
  public int pTI;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177339);
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
      paramVarArgs.aM(5, this.KJJ);
      if (this.openid != null) {
        paramVarArgs.e(6, this.openid);
      }
      paramVarArgs.aM(7, this.KJK);
      paramVarArgs.aM(8, this.pTI);
      paramVarArgs.aM(9, this.KJL);
      paramVarArgs.aM(10, this.scene);
      paramVarArgs.aM(11, this.KIL);
      paramVarArgs.aM(12, this.KIK);
      paramVarArgs.aM(13, this.KIJ);
      if (this.session_id != null) {
        paramVarArgs.e(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.url);
      }
      i += g.a.a.b.b.a.bu(5, this.KJJ);
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.openid);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.KJK) + g.a.a.b.b.a.bu(8, this.pTI) + g.a.a.b.b.a.bu(9, this.KJL) + g.a.a.b.b.a.bu(10, this.scene) + g.a.a.b.b.a.bu(11, this.KIL) + g.a.a.b.b.a.bu(12, this.KIK) + g.a.a.b.b.a.bu(13, this.KIJ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fu localfu = (fu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
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
            localfu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localfu.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localfu.KJJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localfu.openid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localfu.KJK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localfu.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localfu.KJL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localfu.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localfu.KIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localfu.KIK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localfu.KIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(177339);
          return 0;
        }
        localfu.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */