package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ars
  extends dyl
{
  public aqe SDi;
  public LinkedList<String> SEB;
  public LinkedList<String> SEC;
  public String SEZ;
  public int SEy;
  public LinkedList<String> SEz;
  public b SFa;
  public LinkedList<bkt> SFb;
  public bda SFc;
  public LinkedList<String> SFd;
  public String SFe;
  public int businessType;
  public String clientId;
  public String finderUsername;
  public FinderObjectDesc objectDesc;
  public int scene;
  
  public ars()
  {
    AppMethodBeat.i(230956);
    this.SFb = new LinkedList();
    this.SEz = new LinkedList();
    this.SFd = new LinkedList();
    this.SEB = new LinkedList();
    this.SEC = new LinkedList();
    AppMethodBeat.o(230956);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230960);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.oE(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.f(5, this.clientId);
      }
      if (this.SEZ != null) {
        paramVarArgs.f(6, this.SEZ);
      }
      paramVarArgs.aY(7, this.businessType);
      paramVarArgs.aY(8, this.scene);
      if (this.SFa != null) {
        paramVarArgs.c(9, this.SFa);
      }
      paramVarArgs.e(10, 8, this.SFb);
      if (this.SFc != null)
      {
        paramVarArgs.oE(11, this.SFc.computeSize());
        this.SFc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.SEy);
      paramVarArgs.e(13, 1, this.SEz);
      paramVarArgs.e(14, 1, this.SFd);
      paramVarArgs.e(15, 1, this.SEB);
      paramVarArgs.e(16, 1, this.SEC);
      if (this.SFe != null) {
        paramVarArgs.f(17, this.SFe);
      }
      AppMethodBeat.o(230960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1476;
      }
    }
    label1476:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + g.a.a.a.oD(4, this.objectDesc.computeSize());
      }
      i = paramInt;
      if (this.clientId != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.clientId);
      }
      paramInt = i;
      if (this.SEZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SEZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.businessType) + g.a.a.b.b.a.bM(8, this.scene);
      paramInt = i;
      if (this.SFa != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.SFa);
      }
      i = paramInt + g.a.a.a.c(10, 8, this.SFb);
      paramInt = i;
      if (this.SFc != null) {
        paramInt = i + g.a.a.a.oD(11, this.SFc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.SEy) + g.a.a.a.c(13, 1, this.SEz) + g.a.a.a.c(14, 1, this.SFd) + g.a.a.a.c(15, 1, this.SEB) + g.a.a.a.c(16, 1, this.SEC);
      paramInt = i;
      if (this.SFe != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SFe);
      }
      AppMethodBeat.o(230960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SFb.clear();
        this.SEz.clear();
        this.SFd.clear();
        this.SEB.clear();
        this.SEC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230960);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ars localars = (ars)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230960);
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
            localars.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230960);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localars.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230960);
          return 0;
        case 3: 
          localars.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230960);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObjectDesc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
            }
            localars.objectDesc = ((FinderObjectDesc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230960);
          return 0;
        case 5: 
          localars.clientId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230960);
          return 0;
        case 6: 
          localars.SEZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230960);
          return 0;
        case 7: 
          localars.businessType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230960);
          return 0;
        case 8: 
          localars.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230960);
          return 0;
        case 9: 
          localars.SFa = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230960);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkt)localObject2).parseFrom((byte[])localObject1);
            }
            localars.SFb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230960);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bda();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bda)localObject2).parseFrom((byte[])localObject1);
            }
            localars.SFc = ((bda)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230960);
          return 0;
        case 12: 
          localars.SEy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230960);
          return 0;
        case 13: 
          localars.SEz.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(230960);
          return 0;
        case 14: 
          localars.SFd.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(230960);
          return 0;
        case 15: 
          localars.SEB.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(230960);
          return 0;
        case 16: 
          localars.SEC.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(230960);
          return 0;
        }
        localars.SFe = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(230960);
        return 0;
      }
      AppMethodBeat.o(230960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ars
 * JD-Core Version:    0.7.0.1
 */