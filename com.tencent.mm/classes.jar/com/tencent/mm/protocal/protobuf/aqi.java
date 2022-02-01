package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqi
  extends com.tencent.mm.bw.a
{
  public aqr EJn;
  public String EJo;
  public int Edq;
  public String Etm;
  public String IconUrl;
  public String Name;
  public String hOf;
  public String thq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Etm == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.EJn == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.hOf != null) {
        paramVarArgs.d(1, this.hOf);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Etm != null) {
        paramVarArgs.d(3, this.Etm);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.thq != null) {
        paramVarArgs.d(5, this.thq);
      }
      if (this.EJn != null)
      {
        paramVarArgs.ln(6, this.EJn.computeSize());
        this.EJn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Edq);
      if (this.EJo != null) {
        paramVarArgs.d(8, this.EJo);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hOf == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.hOf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Etm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Etm);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.thq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.thq);
      }
      paramInt = i;
      if (this.EJn != null) {
        paramInt = i + f.a.a.a.lm(6, this.EJn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Edq);
      paramInt = i;
      if (this.EJo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EJo);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.hOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Etm == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.EJn == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42632);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqi localaqi = (aqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localaqi.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localaqi.Name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localaqi.Etm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localaqi.IconUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localaqi.thq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aqr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqi.EJn = ((aqr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localaqi.Edq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(42632);
          return 0;
        }
        localaqi.EJo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqi
 * JD-Core Version:    0.7.0.1
 */