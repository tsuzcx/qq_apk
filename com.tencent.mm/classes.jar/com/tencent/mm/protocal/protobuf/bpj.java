package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bpj
  extends dyl
{
  public String MFj;
  public int TaU;
  public int TaV;
  public String TaW;
  public String TaX;
  public String TaY;
  public int TaZ;
  public String appid;
  public int count;
  public String desc;
  public int scene;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72476);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.TaX == null)
      {
        paramVarArgs = new b("Not all required fields were included: busi_id");
        AppMethodBeat.o(72476);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TaU);
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      if (this.desc != null) {
        paramVarArgs.f(4, this.desc);
      }
      paramVarArgs.aY(5, this.TaV);
      if (this.TaW != null) {
        paramVarArgs.f(6, this.TaW);
      }
      paramVarArgs.aY(7, this.count);
      paramVarArgs.aY(8, this.scene);
      if (this.TaX != null) {
        paramVarArgs.f(9, this.TaX);
      }
      if (this.sign != null) {
        paramVarArgs.f(10, this.sign);
      }
      if (this.TaY != null) {
        paramVarArgs.f(11, this.TaY);
      }
      paramVarArgs.aY(12, this.TaZ);
      if (this.MFj != null) {
        paramVarArgs.f(13, this.MFj);
      }
      AppMethodBeat.o(72476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1040;
      }
    }
    label1040:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TaU);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.appid);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.desc);
      }
      i += g.a.a.b.b.a.bM(5, this.TaV);
      paramInt = i;
      if (this.TaW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TaW);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.count) + g.a.a.b.b.a.bM(8, this.scene);
      paramInt = i;
      if (this.TaX != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TaX);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.sign);
      }
      paramInt = i;
      if (this.TaY != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TaY);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.TaZ);
      paramInt = i;
      if (this.MFj != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.MFj);
      }
      AppMethodBeat.o(72476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        if (this.TaX == null)
        {
          paramVarArgs = new b("Not all required fields were included: busi_id");
          AppMethodBeat.o(72476);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bpj localbpj = (bpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72476);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbpj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72476);
          return 0;
        case 2: 
          localbpj.TaU = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72476);
          return 0;
        case 3: 
          localbpj.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 4: 
          localbpj.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 5: 
          localbpj.TaV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72476);
          return 0;
        case 6: 
          localbpj.TaW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 7: 
          localbpj.count = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72476);
          return 0;
        case 8: 
          localbpj.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72476);
          return 0;
        case 9: 
          localbpj.TaX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 10: 
          localbpj.sign = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 11: 
          localbpj.TaY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72476);
          return 0;
        case 12: 
          localbpj.TaZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72476);
          return 0;
        }
        localbpj.MFj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72476);
        return 0;
      }
      AppMethodBeat.o(72476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpj
 * JD-Core Version:    0.7.0.1
 */