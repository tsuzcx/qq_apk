package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgs
  extends dyl
{
  public ack RPD;
  public int RYM;
  public String TnF;
  public int TnG;
  public int TnH;
  public String TnI;
  public boolean TnJ;
  public dhp TnK;
  public String TnL;
  public LinkedList<czt> TnM;
  public int TnN;
  public boolean TnO;
  public boolean TnP;
  public String appid;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public cgs()
  {
    AppMethodBeat.i(123586);
    this.TnJ = false;
    this.TnM = new LinkedList();
    AppMethodBeat.o(123586);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123587);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.type);
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      paramVarArgs.aY(4, this.RYM);
      if (this.TnF != null) {
        paramVarArgs.f(5, this.TnF);
      }
      paramVarArgs.aY(6, this.TnG);
      paramVarArgs.aY(7, this.TnH);
      if (this.TnI != null) {
        paramVarArgs.f(8, this.TnI);
      }
      paramVarArgs.co(9, this.TnJ);
      if (this.TnK != null)
      {
        paramVarArgs.oE(10, this.TnK.computeSize());
        this.TnK.writeFields(paramVarArgs);
      }
      if (this.TnL != null) {
        paramVarArgs.f(11, this.TnL);
      }
      paramVarArgs.e(12, 8, this.TnM);
      paramVarArgs.aY(13, this.TnN);
      if (this.username != null) {
        paramVarArgs.f(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.f(15, this.path);
      }
      paramVarArgs.co(16, this.TnO);
      paramVarArgs.co(17, this.TnP);
      paramVarArgs.aY(18, this.scene);
      if (this.RPD != null)
      {
        paramVarArgs.oE(19, this.RPD.computeSize());
        this.RPD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1442;
      }
    }
    label1442:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.appid);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.RYM);
      paramInt = i;
      if (this.TnF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TnF);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TnG) + g.a.a.b.b.a.bM(7, this.TnH);
      paramInt = i;
      if (this.TnI != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TnI);
      }
      i = paramInt + (g.a.a.b.b.a.gL(9) + 1);
      paramInt = i;
      if (this.TnK != null) {
        paramInt = i + g.a.a.a.oD(10, this.TnK.computeSize());
      }
      i = paramInt;
      if (this.TnL != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TnL);
      }
      i = i + g.a.a.a.c(12, 8, this.TnM) + g.a.a.b.b.a.bM(13, this.TnN);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.path);
      }
      i = i + (g.a.a.b.b.a.gL(16) + 1) + (g.a.a.b.b.a.gL(17) + 1) + g.a.a.b.b.a.bM(18, this.scene);
      paramInt = i;
      if (this.RPD != null) {
        paramInt = i + g.a.a.a.oD(19, this.RPD.computeSize());
      }
      AppMethodBeat.o(123587);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TnM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgs localcgs = (cgs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
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
            localcgs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localcgs.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localcgs.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localcgs.RYM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localcgs.TnF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localcgs.TnG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localcgs.TnH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localcgs.TnI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localcgs.TnJ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhp)localObject2).parseFrom((byte[])localObject1);
            }
            localcgs.TnK = ((dhp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localcgs.TnL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new czt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((czt)localObject2).parseFrom((byte[])localObject1);
            }
            localcgs.TnM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localcgs.TnN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localcgs.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localcgs.path = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localcgs.TnO = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localcgs.TnP = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123587);
          return 0;
        case 18: 
          localcgs.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123587);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ack();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ack)localObject2).parseFrom((byte[])localObject1);
          }
          localcgs.RPD = ((ack)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgs
 * JD-Core Version:    0.7.0.1
 */