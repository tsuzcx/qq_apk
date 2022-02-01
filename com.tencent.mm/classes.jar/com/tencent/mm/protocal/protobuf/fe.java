package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fe
  extends ckq
{
  public int CyP;
  public int CyQ;
  public int CyR;
  public long CyS;
  public int CzO;
  public int CzR;
  public long CzU;
  public String content;
  public int ntg;
  public int scene;
  public String session_id;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aG(5, this.CzU);
      paramVarArgs.aR(6, this.ntg);
      paramVarArgs.aR(7, this.CzO);
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aR(9, this.scene);
      paramVarArgs.aR(10, this.CyR);
      paramVarArgs.aR(11, this.CyQ);
      paramVarArgs.aR(12, this.CyP);
      if (this.session_id != null) {
        paramVarArgs.d(13, this.session_id);
      }
      paramVarArgs.aG(14, this.CyS);
      paramVarArgs.aR(15, this.CzR);
      AppMethodBeat.o(103199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.content);
      }
      i = i + f.a.a.b.b.a.q(5, this.CzU) + f.a.a.b.b.a.bA(6, this.ntg) + f.a.a.b.b.a.bA(7, this.CzO);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.scene) + f.a.a.b.b.a.bA(10, this.CyR) + f.a.a.b.b.a.bA(11, this.CyQ) + f.a.a.b.b.a.bA(12, this.CyP);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.session_id);
      }
      i = f.a.a.b.b.a.q(14, this.CyS);
      int j = f.a.a.b.b.a.bA(15, this.CzR);
      AppMethodBeat.o(103199);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fe localfe = (fe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103199);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfe.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103199);
          return 0;
        case 2: 
          localfe.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 4: 
          localfe.content = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 5: 
          localfe.CzU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(103199);
          return 0;
        case 6: 
          localfe.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103199);
          return 0;
        case 7: 
          localfe.CzO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103199);
          return 0;
        case 8: 
          localfe.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 9: 
          localfe.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103199);
          return 0;
        case 10: 
          localfe.CyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103199);
          return 0;
        case 11: 
          localfe.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103199);
          return 0;
        case 12: 
          localfe.CyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103199);
          return 0;
        case 13: 
          localfe.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 14: 
          localfe.CyS = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(103199);
          return 0;
        }
        localfe.CzR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103199);
        return 0;
      }
      AppMethodBeat.o(103199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fe
 * JD-Core Version:    0.7.0.1
 */