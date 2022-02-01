package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qg
  extends cvw
{
  public String AXb;
  public String AXc;
  public ald FOi;
  public int FOj;
  public String FOp;
  public String GdJ;
  public String GdP;
  public String GdQ;
  public String GdR;
  public int GdS;
  public boolean GdT;
  public boolean GdU;
  public String GdV;
  public int GdW;
  public String GdX;
  public int GdY;
  public int GdZ;
  public String Gea;
  public String Geb;
  public int channel;
  public String iWC;
  public String nickname;
  public int scene;
  public int yns;
  public String yoN;
  public String yoO;
  public String yoQ;
  public int yoS;
  public String yoT;
  public String yoU;
  public String yoq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GdP == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yoT != null) {
        paramVarArgs.d(2, this.yoT);
      }
      if (this.GdP != null) {
        paramVarArgs.d(3, this.GdP);
      }
      paramVarArgs.aS(4, this.scene);
      if (this.GdQ != null) {
        paramVarArgs.d(5, this.GdQ);
      }
      if (this.yoN != null) {
        paramVarArgs.d(6, this.yoN);
      }
      paramVarArgs.aS(7, this.FOj);
      paramVarArgs.aS(8, this.channel);
      if (this.yoU != null) {
        paramVarArgs.d(9, this.yoU);
      }
      if (this.yoO != null) {
        paramVarArgs.d(10, this.yoO);
      }
      if (this.GdR != null) {
        paramVarArgs.d(11, this.GdR);
      }
      paramVarArgs.aS(12, this.GdS);
      paramVarArgs.aS(13, this.yoS);
      if (this.iWC != null) {
        paramVarArgs.d(14, this.iWC);
      }
      if (this.FOi != null)
      {
        paramVarArgs.lJ(15, this.FOi.computeSize());
        this.FOi.writeFields(paramVarArgs);
      }
      if (this.GdJ != null) {
        paramVarArgs.d(16, this.GdJ);
      }
      paramVarArgs.aS(17, this.yns);
      paramVarArgs.bC(18, this.GdT);
      paramVarArgs.bC(19, this.GdU);
      if (this.AXb != null) {
        paramVarArgs.d(20, this.AXb);
      }
      if (this.AXc != null) {
        paramVarArgs.d(21, this.AXc);
      }
      if (this.GdV != null) {
        paramVarArgs.d(22, this.GdV);
      }
      if (this.yoQ != null) {
        paramVarArgs.d(23, this.yoQ);
      }
      if (this.nickname != null) {
        paramVarArgs.d(24, this.nickname);
      }
      if (this.yoq != null) {
        paramVarArgs.d(25, this.yoq);
      }
      paramVarArgs.aS(26, this.GdW);
      if (this.GdX != null) {
        paramVarArgs.d(27, this.GdX);
      }
      paramVarArgs.aS(28, this.GdY);
      paramVarArgs.aS(29, this.GdZ);
      if (this.FOp != null) {
        paramVarArgs.d(30, this.FOp);
      }
      if (this.Gea != null) {
        paramVarArgs.d(31, this.Gea);
      }
      if (this.Geb != null) {
        paramVarArgs.d(32, this.Geb);
      }
      AppMethodBeat.o(91374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2174;
      }
    }
    label2174:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yoT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yoT);
      }
      i = paramInt;
      if (this.GdP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GdP);
      }
      i += f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.GdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GdQ);
      }
      i = paramInt;
      if (this.yoN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yoN);
      }
      i = i + f.a.a.b.b.a.bz(7, this.FOj) + f.a.a.b.b.a.bz(8, this.channel);
      paramInt = i;
      if (this.yoU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.yoU);
      }
      i = paramInt;
      if (this.yoO != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.yoO);
      }
      paramInt = i;
      if (this.GdR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GdR);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.GdS) + f.a.a.b.b.a.bz(13, this.yoS);
      paramInt = i;
      if (this.iWC != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iWC);
      }
      i = paramInt;
      if (this.FOi != null) {
        i = paramInt + f.a.a.a.lI(15, this.FOi.computeSize());
      }
      paramInt = i;
      if (this.GdJ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GdJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.yns) + f.a.a.b.b.a.amF(18) + f.a.a.b.b.a.amF(19);
      paramInt = i;
      if (this.AXb != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.AXb);
      }
      i = paramInt;
      if (this.AXc != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.AXc);
      }
      paramInt = i;
      if (this.GdV != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GdV);
      }
      i = paramInt;
      if (this.yoQ != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.yoQ);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.nickname);
      }
      i = paramInt;
      if (this.yoq != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.yoq);
      }
      i += f.a.a.b.b.a.bz(26, this.GdW);
      paramInt = i;
      if (this.GdX != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.GdX);
      }
      i = paramInt + f.a.a.b.b.a.bz(28, this.GdY) + f.a.a.b.b.a.bz(29, this.GdZ);
      paramInt = i;
      if (this.FOp != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.FOp);
      }
      i = paramInt;
      if (this.Gea != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.Gea);
      }
      paramInt = i;
      if (this.Geb != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Geb);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GdP == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(91374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qg localqg = (qg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localqg.yoT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localqg.GdP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localqg.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localqg.GdQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localqg.yoN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localqg.FOj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localqg.channel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localqg.yoU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localqg.yoO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localqg.GdR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localqg.GdS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localqg.yoS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localqg.iWC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ald();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ald)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqg.FOi = ((ald)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localqg.GdJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localqg.yns = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localqg.GdT = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localqg.GdU = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localqg.AXb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localqg.AXc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localqg.GdV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localqg.yoQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localqg.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localqg.yoq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localqg.GdW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localqg.GdX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localqg.GdY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localqg.GdZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localqg.FOp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localqg.Gea = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91374);
          return 0;
        }
        localqg.Geb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qg
 * JD-Core Version:    0.7.0.1
 */