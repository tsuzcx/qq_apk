package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fw
  extends dop
{
  public int KIJ;
  public int KIK;
  public int KIL;
  public String KJM;
  public int pTI;
  public String request_id;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103197);
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
      if (this.request_id != null) {
        paramVarArgs.e(3, this.request_id);
      }
      if (this.KJM != null) {
        paramVarArgs.e(4, this.KJM);
      }
      paramVarArgs.aM(5, this.scene);
      paramVarArgs.aM(6, this.KIL);
      paramVarArgs.aM(7, this.KIK);
      paramVarArgs.aM(8, this.pTI);
      paramVarArgs.aM(10, this.KIJ);
      if (this.session_id != null) {
        paramVarArgs.e(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.request_id != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.request_id);
      }
      paramInt = i;
      if (this.KJM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KJM);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.scene) + g.a.a.b.b.a.bu(6, this.KIL) + g.a.a.b.b.a.bu(7, this.KIK) + g.a.a.b.b.a.bu(8, this.pTI) + g.a.a.b.b.a.bu(10, this.KIJ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fw localfw = (fw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(103197);
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
            localfw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103197);
          return 0;
        case 2: 
          localfw.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 3: 
          localfw.request_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 4: 
          localfw.KJM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 5: 
          localfw.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103197);
          return 0;
        case 6: 
          localfw.KIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103197);
          return 0;
        case 7: 
          localfw.KIK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103197);
          return 0;
        case 8: 
          localfw.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103197);
          return 0;
        case 10: 
          localfw.KIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103197);
          return 0;
        }
        localfw.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103197);
        return 0;
      }
      AppMethodBeat.o(103197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fw
 * JD-Core Version:    0.7.0.1
 */