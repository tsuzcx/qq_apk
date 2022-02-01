package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ey
  extends ckq
{
  public int CyQ;
  public int CyR;
  public int Czq;
  public int Czr;
  public long Czs;
  public long Czt;
  public nx Czu;
  public int Czv;
  public int Czw;
  public int Czx;
  public String Czy;
  public String gGC;
  public int nettype;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103194);
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
      if (this.gGC != null) {
        paramVarArgs.d(3, this.gGC);
      }
      paramVarArgs.aR(4, this.scene);
      paramVarArgs.aR(5, this.CyR);
      paramVarArgs.aR(6, this.nettype);
      if (this.session_id != null) {
        paramVarArgs.d(7, this.session_id);
      }
      paramVarArgs.aR(8, this.CyQ);
      paramVarArgs.aR(9, this.Czq);
      paramVarArgs.aR(10, this.Czr);
      paramVarArgs.aG(11, this.Czs);
      paramVarArgs.aG(12, this.Czt);
      if (this.Czu != null)
      {
        paramVarArgs.kX(13, this.Czu.computeSize());
        this.Czu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.Czv);
      paramVarArgs.aR(15, this.Czw);
      paramVarArgs.aR(16, this.Czx);
      if (this.Czy != null) {
        paramVarArgs.d(17, this.Czy);
      }
      AppMethodBeat.o(103194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.gGC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gGC);
      }
      i = i + f.a.a.b.b.a.bA(4, this.scene) + f.a.a.b.b.a.bA(5, this.CyR) + f.a.a.b.b.a.bA(6, this.nettype);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.session_id);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CyQ) + f.a.a.b.b.a.bA(9, this.Czq) + f.a.a.b.b.a.bA(10, this.Czr) + f.a.a.b.b.a.q(11, this.Czs) + f.a.a.b.b.a.q(12, this.Czt);
      paramInt = i;
      if (this.Czu != null) {
        paramInt = i + f.a.a.a.kW(13, this.Czu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.Czv) + f.a.a.b.b.a.bA(15, this.Czw) + f.a.a.b.b.a.bA(16, this.Czx);
      paramInt = i;
      if (this.Czy != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Czy);
      }
      AppMethodBeat.o(103194);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ey localey = (ey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103194);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localey.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 2: 
          localey.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 3: 
          localey.gGC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 4: 
          localey.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 5: 
          localey.CyR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 6: 
          localey.nettype = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 7: 
          localey.session_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 8: 
          localey.CyQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 9: 
          localey.Czq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 10: 
          localey.Czr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 11: 
          localey.Czs = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(103194);
          return 0;
        case 12: 
          localey.Czt = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(103194);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localey.Czu = ((nx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 14: 
          localey.Czv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 15: 
          localey.Czw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        case 16: 
          localey.Czx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(103194);
          return 0;
        }
        localey.Czy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103194);
        return 0;
      }
      AppMethodBeat.o(103194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ey
 * JD-Core Version:    0.7.0.1
 */