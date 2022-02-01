package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fc
  extends ckq
{
  public int CyP;
  public int CyQ;
  public int CyR;
  public String CzS;
  public String hea;
  public int ntg;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103197);
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
      if (this.hea != null) {
        paramVarArgs.d(3, this.hea);
      }
      if (this.CzS != null) {
        paramVarArgs.d(4, this.CzS);
      }
      paramVarArgs.aR(5, this.scene);
      paramVarArgs.aR(6, this.CyR);
      paramVarArgs.aR(7, this.CyQ);
      paramVarArgs.aR(8, this.ntg);
      paramVarArgs.aR(10, this.CyP);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hea != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hea);
      }
      paramInt = i;
      if (this.CzS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CzS);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.scene) + f.a.a.b.b.a.bA(6, this.CyR) + f.a.a.b.b.a.bA(7, this.CyQ) + f.a.a.b.b.a.bA(8, this.ntg) + f.a.a.b.b.a.bA(10, this.CyP);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fc localfc = (fc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(103197);
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
            localfc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103197);
          return 0;
        case 2: 
          localfc.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 3: 
          localfc.hea = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 4: 
          localfc.CzS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 5: 
          localfc.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103197);
          return 0;
        case 6: 
          localfc.CyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103197);
          return 0;
        case 7: 
          localfc.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103197);
          return 0;
        case 8: 
          localfc.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103197);
          return 0;
        case 10: 
          localfc.CyP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103197);
          return 0;
        }
        localfc.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103197);
        return 0;
      }
      AppMethodBeat.o(103197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fc
 * JD-Core Version:    0.7.0.1
 */