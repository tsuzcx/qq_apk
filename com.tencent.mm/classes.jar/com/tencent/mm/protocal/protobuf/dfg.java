package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfg
  extends com.tencent.mm.cd.a
{
  public String RIS;
  public String RLN;
  public String TML;
  public String TMM;
  public String TMW;
  public String TMY;
  public String TMZ;
  public String TNa;
  public String TNb;
  public dfh TNc;
  public String app_id;
  public String myd;
  public String nickname;
  public String remark;
  public int sex;
  public int source;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.myd != null) {
        paramVarArgs.f(1, this.myd);
      }
      if (this.nickname != null) {
        paramVarArgs.f(2, this.nickname);
      }
      paramVarArgs.aY(3, this.type);
      if (this.remark != null) {
        paramVarArgs.f(4, this.remark);
      }
      if (this.TML != null) {
        paramVarArgs.f(5, this.TML);
      }
      if (this.TMM != null) {
        paramVarArgs.f(6, this.TMM);
      }
      paramVarArgs.aY(7, this.source);
      if (this.TMY != null) {
        paramVarArgs.f(8, this.TMY);
      }
      if (this.TMZ != null) {
        paramVarArgs.f(9, this.TMZ);
      }
      if (this.TNa != null) {
        paramVarArgs.f(10, this.TNa);
      }
      if (this.TNb != null) {
        paramVarArgs.f(11, this.TNb);
      }
      if (this.TNc != null)
      {
        paramVarArgs.oE(12, this.TNc.computeSize());
        this.TNc.writeFields(paramVarArgs);
      }
      if (this.RIS != null) {
        paramVarArgs.f(13, this.RIS);
      }
      if (this.app_id != null) {
        paramVarArgs.f(14, this.app_id);
      }
      paramVarArgs.aY(15, this.sex);
      if (this.TMW != null) {
        paramVarArgs.f(16, this.TMW);
      }
      if (this.RLN != null) {
        paramVarArgs.f(17, this.RLN);
      }
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.myd == null) {
        break label1224;
      }
    }
    label1224:
    for (paramInt = g.a.a.b.b.a.g(1, this.myd) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.nickname);
      }
      i += g.a.a.b.b.a.bM(3, this.type);
      paramInt = i;
      if (this.remark != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.remark);
      }
      i = paramInt;
      if (this.TML != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TML);
      }
      paramInt = i;
      if (this.TMM != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TMM);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.source);
      paramInt = i;
      if (this.TMY != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TMY);
      }
      i = paramInt;
      if (this.TMZ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TMZ);
      }
      paramInt = i;
      if (this.TNa != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TNa);
      }
      i = paramInt;
      if (this.TNb != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TNb);
      }
      paramInt = i;
      if (this.TNc != null) {
        paramInt = i + g.a.a.a.oD(12, this.TNc.computeSize());
      }
      i = paramInt;
      if (this.RIS != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.RIS);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.app_id);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.sex);
      paramInt = i;
      if (this.TMW != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.TMW);
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.RLN);
      }
      AppMethodBeat.o(152638);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dfg localdfg = (dfg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localdfg.myd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localdfg.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localdfg.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localdfg.remark = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localdfg.TML = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localdfg.TMM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localdfg.source = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localdfg.TMY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localdfg.TMZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localdfg.TNa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localdfg.TNb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dfh localdfh = new dfh();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfh.parseFrom((byte[])localObject);
            }
            localdfg.TNc = localdfh;
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localdfg.RIS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localdfg.app_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localdfg.sex = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152638);
          return 0;
        case 16: 
          localdfg.TMW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152638);
          return 0;
        }
        localdfg.RLN = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfg
 * JD-Core Version:    0.7.0.1
 */